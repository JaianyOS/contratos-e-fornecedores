package br.com.zup.contratos.e.fornecedores.repositories;

import br.com.zup.contratos.e.fornecedores.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepositorie extends JpaRepository<Fornecedor, Long> {

}
