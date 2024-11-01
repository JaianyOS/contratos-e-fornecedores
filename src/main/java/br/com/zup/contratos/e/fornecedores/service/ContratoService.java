package br.com.zup.contratos.e.fornecedores.service;

import br.com.zup.contratos.e.fornecedores.models.Contrato;
import br.com.zup.contratos.e.fornecedores.models.Fornecedor;
import br.com.zup.contratos.e.fornecedores.repositories.ContratoRepository;
import br.com.zup.contratos.e.fornecedores.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Contrato> buscarContratosComFiltros(Long fornecedorId, LocalDate dataInicio, LocalDate dataTermino, Boolean ativo, String descricao) {
        return contratoRepository.findByFilters(fornecedorId, dataInicio, dataTermino, ativo, descricao);
    }

    public List<Contrato> listarContratos(Long fornecedorId) {
        return contratoRepository.findByFornecedorId(fornecedorId);
    }

    public Optional<Contrato> buscarContrato(Long id) {
        return contratoRepository.findById(id);
    }

    public Contrato criarContrato(Long fornecedorId, Contrato contrato) {
        if (contrato.getDataFim().isBefore(contrato.getDataInicio())) {
            throw new IllegalArgumentException("The end date must be greater than the start date.");
        }
        if (contrato.getDataFim().isAfter(LocalDate.now())) {
            contrato.setAtivo(true);
        } else {
            contrato.setAtivo(false);
        }


        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorId)
                .orElseThrow(() -> new RuntimeException("Supplier not found."));
        contrato.setFornecedor(fornecedor);
        return contratoRepository.save(contrato);
    }

    public Optional<Contrato> atualizarContrato(Long id, Contrato contrato) {
        return contratoRepository.findById(id).map(existingContrato -> {
            if (contrato.getDataFim().isBefore(contrato.getDataInicio())) {
                throw new IllegalArgumentException("The end date must be greater than the start date.");
            }

            existingContrato.setNumeroContrato(contrato.getNumeroContrato());
            existingContrato.setDataInicio(contrato.getDataInicio());
            existingContrato.setDataFim(contrato.getDataFim());
            existingContrato.setValorTotal(contrato.getValorTotal());
            existingContrato.setDescricao(contrato.getDescricao());
            existingContrato.setAtivo(contrato.isAtivo());
            return contratoRepository.save(existingContrato);
        });
    }

    public boolean removerContrato(Long id) {
        return contratoRepository.findById(id).map(contrato -> {
            contratoRepository.delete(contrato);
            return true;
        }).orElse(false);
    }

    @Scheduled(fixedRate = 3600000)
    @Transactional
    public void atualizarContratosExpirados() {
        LocalDate hoje = LocalDate.now();
        List<Contrato> contratosExpirados = contratoRepository.findByDataTerminoBeforeAndAtivoTrue(hoje);

        contratosExpirados.forEach(contrato -> contrato.setAtivo(false));
        contratoRepository.saveAll(contratosExpirados);

        System.out.println("Expired contract: " + contratosExpirados.size());
    }
}