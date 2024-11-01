package br.com.zup.contratos.e.fornecedores.service;

import br.com.zup.contratos.e.fornecedores.models.Fornecedor;
import br.com.zup.contratos.e.fornecedores.repositories.FornecedorRepository;
import jakarta.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;


    public Optional<Object> buscarFornecedor(Long id) {
        return Optional.of(fornecedorRepository.findById(id));
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor criarFornecedor(@Valid Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Optional<Object> atualizarFornecedor(Long id, @Valid Fornecedor fornecedor) {
        return fornecedorRepository.findById(id).map(existingFornecedor -> {
            existingFornecedor.setNome(fornecedor.getNome());
            existingFornecedor.setCNPJ(fornecedor.getCNPJ());
            existingFornecedor.setTelefone(fornecedor.getTelefone());
            existingFornecedor.setEndereco(fornecedor.getEndereco());
            return fornecedorRepository.save(existingFornecedor);
        });
    }

    public boolean removerFornecedor(Long id) {

        return fornecedorRepository.findById(id).map(fornecedor -> {
            fornecedorRepository.delete(fornecedor);
            return true;
        }).orElse(false);
    }
}
