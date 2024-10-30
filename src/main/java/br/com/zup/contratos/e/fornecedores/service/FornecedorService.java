package br.com.zup.contratos.e.fornecedores.service;

import br.com.zup.contratos.e.fornecedores.models.Fornecedor;
import br.com.zup.contratos.e.fornecedores.repositories.FornecedorRepositorie;
import jakarta.validation.Valid;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepositorie fornecedorRepositorie;


    public Optional<Object> buscarFornecedor(Long id) {
    }

    public List listarFornecedores() {
    }

    public Fornecedor criarFornecedor(@Valid Fornecedor fornecedor) {
    }

    public Optional<Object> atualizarFornecedor(Long id, @Valid Fornecedor fornecedor) {
    }

    public boolean removerFornecedor(Long id) {
    }
}
