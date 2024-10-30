package br.com.zup.contratos.e.fornecedores.service.mappers;

import br.com.zup.contratos.e.fornecedores.controllers.dtos.FornecedorRegisterDTO;
import br.com.zup.contratos.e.fornecedores.controllers.dtos.FornecedorUpdateDTO;
import br.com.zup.contratos.e.fornecedores.models.Fornecedor;

public class FornecedorMapper {
    public static Fornecedor fromFornecedorRegisterDTO(FornecedorRegisterDTO fornecedorRegisterDTO) {
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNome(fornecedorRegisterDTO.getNome());
        fornecedor.setCNPJ(fornecedorRegisterDTO.getCNPJ());
        fornecedor.setEndereco(fornecedorRegisterDTO.getEndereco());
        fornecedor.setTelefone(fornecedorRegisterDTO.getTelefone());

        return fornecedor;
    }

    public static Fornecedor fromFornecedorUpdateDTO(FornecedorUpdateDTO fornecedorUpdateDTO) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(fornecedorUpdateDTO.getId());
        fornecedor.setNome(fornecedorUpdateDTO.getNome());
        fornecedor.setCNPJ(fornecedorUpdateDTO.getCNPJ());
        fornecedor.setEndereco(fornecedorUpdateDTO.getEndereco());
        fornecedor.setTelefone(fornecedorUpdateDTO.getTelefone());

        return fornecedor;
    }
}
