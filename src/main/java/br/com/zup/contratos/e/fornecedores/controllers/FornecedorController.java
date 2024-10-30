package br.com.zup.contratos.e.fornecedores.controllers;

import br.com.zup.contratos.e.fornecedores.controllers.dtos.FornecedorRegisterDTO;
import br.com.zup.contratos.e.fornecedores.models.Fornecedor;
import br.com.zup.contratos.e.fornecedores.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor registerFornecedor(@RequestBody @Valid Fornecedor fornecedor) {
        return FornecedorService.saveFornecedor(FornecedorMapper.fromFornecedorRegisterDTO(FornecedorRegisterDTO));
    }
}
