package br.com.zup.contratos.e.fornecedores.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
public class Contrato {
    @Id
    private Long id;
    private String numeroContrato;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    @Min(value = 1, message = "The contract value must be greater than zaro.")
    private BigDecimal valorTotal;
    private String descricao;
    private boolean ativo;
    @ManyToOne
    private Fornecedor fornecedor;

    public Contrato() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNumeroContrato() {
        return numeroContrato;
    }
    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    public BigDecimal getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {

    }
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDate getDataTermino() {
        return this.dataFim;
    }
}
