package com.queimadas.queimadas_monitoramento.controller;

import com.queimadas.queimadas_monitoramento.domain.Regiao;
import com.queimadas.queimadas_monitoramento.service.RegiaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regioes")
public class RegiaoController {

    private final RegiaoService service;

    public RegiaoController(RegiaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Regiao> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Regiao> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Regiao criar(@RequestBody Regiao regiao) {
        return service.salvar(regiao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Regiao> atualizar(@PathVariable Long id, @RequestBody Regiao regiao) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        regiao.setId(id);
        return ResponseEntity.ok(service.salvar(regiao));
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
