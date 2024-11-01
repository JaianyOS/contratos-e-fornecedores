package br.com.zup.contratos.e.fornecedores.repositories;

import br.com.zup.contratos.e.fornecedores.models.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    @Query("SELECT c FROM Contrato c WHERE " +
    "(:dataInicio IS NULL OR c.dataInicio = :dataInicio) AND " +
    "(:dataTermino IS NULL OR c.dataTermino = :dataTermino) AND " +
    "(:ativo IS NULL OR c.ativo = :ativo) AND " +
    "(:descricao IS NULL OR LOWER(c.descricao) LIKE LOWER(CONCAT('%', :descricao, '%'))) AND " +
    "c.fornecedor.id = :fornecedorId")

    List<Contrato> findByFilters(@Param("fornecedorId") Long fornecedorId,
                                 @Param("dataInicio") LocalDate dataInicio,
                                 @Param("dataTermino") LocalDate dataTermino,
                                 @Param("ativo") Boolean ativo,
                                 @Param("descricao") String descricao);

    List<Contrato> findByFornecedorId(Long fornecedorId);
}
