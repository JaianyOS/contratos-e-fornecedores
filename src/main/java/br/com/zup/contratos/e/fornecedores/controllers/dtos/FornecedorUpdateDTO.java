package br.com.zup.contratos.e.fornecedores.controllers.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FornecedorUpdateDTO {
    @NotNull
    private Long id;
    private String nome;
    @org.hibernate.validator.constraints.br.CNPJ (message = "CNPJ not valid")
    private String CNPJ;
    @Size(min = 11, max = 11)
    private String telefone;
    private String endereco;

    public FornecedorUpdateDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


}
