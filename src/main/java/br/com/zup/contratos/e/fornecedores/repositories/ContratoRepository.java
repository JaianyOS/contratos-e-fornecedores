package br.com.zup.contratos.e.fornecedores.repositories;

import br.com.zup.contratos.e.fornecedores.models.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    List<Contrato> findByFornecedorId(Long fornecedorId);
}
