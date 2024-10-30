package br.com.zup.contratos.e.fornecedores.service;

import br.com.zup.contratos.e.fornecedores.repositories.FornecedorRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepositorie fornecedorRepositorie;


}
