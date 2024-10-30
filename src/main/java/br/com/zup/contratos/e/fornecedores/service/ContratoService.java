package br.com.zup.contratos.e.fornecedores.service;

import br.com.zup.contratos.e.fornecedores.models.Contrato;
import br.com.zup.contratos.e.fornecedores.models.Fornecedor;
import br.com.zup.contratos.e.fornecedores.repositories.ContratoRepositorie;
import br.com.zup.contratos.e.fornecedores.repositories.FornecedorRepositorie;
import jakarta.validation.Valid;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

import java.time.LocalDate;
import java.util.Optional;

public class ContratoService {
    @Autowired
    private ContratoRepositorie contratoRepositorie;

    @Autowired
    private FornecedorRepositorie fornecedorRepositorie;

    public Contrato criarContrato(Long fornecedorId, Contrato contrato) {
        Fornecedor fornecedor = fornecedorRepositorie.findById(fornecedorId)
                .orElseThrow(() -> new ConfigDataResourceNotFoundException("Fornecedor não encontrado"));

        contrato.setFornecedor(fornecedor);

        boolean ativo = contrato.getDataTermino().isAfter(LocalDate.now());
        contrato.setAtivo(ativo);

        return contratoRepositorie.save(contrato);
}

    public List listarContratos(Long fornecedorId) {
    }

    public Optional<Object> buscarContrato(Long id) {
    }

    public Optional<Object> atualizarContrato(Long id, @Valid Contrato contrato) {
    }

    public boolean removerContrato(Long id) {
    }
