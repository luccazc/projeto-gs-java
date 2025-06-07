package com.queimadas.queimadas_monitoramento.controller;

import com.queimadas.queimadas_monitoramento.domain.AgenteAmbiental;
import com.queimadas.queimadas_monitoramento.service.AgenteAmbientalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agentes-ambientais")
public class AgenteAmbientalController {

    private final AgenteAmbientalService service;

    public AgenteAmbientalController(AgenteAmbientalService service) {
        this.service = service;
    }

    @GetMapping
    public List<AgenteAmbiental> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenteAmbiental> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AgenteAmbiental criar(@RequestBody AgenteAmbiental agente) {
        return service.salvar(agente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgenteAmbiental> atualizar(@PathVariable Long id, @RequestBody AgenteAmbiental agente) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        agente.setId(id);
        return ResponseEntity.ok(service.salvar(agente));
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
