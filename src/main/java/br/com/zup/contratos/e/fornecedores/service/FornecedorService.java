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
    private FornecedorRepository fornecedorRepositorie;
    @Autowired
    private FornecedorRepository fornecedorRepository;


    public Optional<Object> buscarFornecedor(Long id) {
        return Optional.of(fornecedorRepository.findById(id));
    }

    public List listarFornecedores() {
        return List.of();
    }

    public Fornecedor criarFornecedor(@Valid Fornecedor fornecedor) {
        return fornecedor;
    }

    public Optional<Object> atualizarFornecedor(Long id, @Valid Fornecedor fornecedor) {
        return Optional.empty();
    }

    public boolean removerFornecedor(Long id) {
        return false;
    }
}
