package br.com.zup.contratos.e.fornecedores.controllers;

import br.com.zup.contratos.e.fornecedores.models.Contrato;
import br.com.zup.contratos.e.fornecedores.service.ContratoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping("/fornecedores/{fornecedorId}/contratos")
    public ResponseEntity<List<Contrato>> listarContratosComFiltros(
            @PathVariable Long fornecedorId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataTermino,
            @RequestParam(required = false) Boolean ativo,
            @RequestParam(required = false) String descricao) {

        List<Contrato> contratos = contratoService.buscarContratosComFiltros(fornecedorId, dataInicial, dataTermino, ativo, descricao);
        return ResponseEntity.ok(contratos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarContrato(@PathVariable Long id) {
        Optional<Contrato> contrato = contratoService.buscarContrato(id);
        return contrato.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/fornecedores/{fornecedorId}/contratos")
    public ResponseEntity<Contrato> criarContrato(@PathVariable Long fornecedorId, @RequestBody @Valid Contrato contrato) {
        Contrato novoContrato = contratoService.criarContrato(fornecedorId, contrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoContrato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> atualizarContrato(@PathVariable Long id, @RequestBody @Valid Contrato contrato) {
        return contratoService.atualizarContrato(id, contrato)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerContrato(@PathVariable Long id) {
        if (contratoService.removerContrato(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}