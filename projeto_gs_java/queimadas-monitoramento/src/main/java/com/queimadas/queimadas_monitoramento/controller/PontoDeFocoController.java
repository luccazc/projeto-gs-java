package com.queimadas.queimadas_monitoramento.controller;

import com.queimadas.queimadas_monitoramento.domain.PontoDeFoco;
import com.queimadas.queimadas_monitoramento.service.PontoDeFocoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pontos-de-foco")
public class PontoDeFocoController {

     private final PontoDeFocoService service;

    public PontoDeFocoController(PontoDeFocoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PontoDeFoco> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoDeFoco> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PontoDeFoco criar(@RequestBody PontoDeFoco pontoDeFoco) {
        return service.salvar(pontoDeFoco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PontoDeFoco> atualizar(@PathVariable Long id, @RequestBody PontoDeFoco pontoDeFoco) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pontoDeFoco.setId(id);
        return ResponseEntity.ok(service.salvar(pontoDeFoco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
