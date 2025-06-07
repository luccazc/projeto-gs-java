package com.queimadas.queimadas_monitoramento.service;

import com.queimadas.queimadas_monitoramento.domain.Alerta;
import com.queimadas.queimadas_monitoramento.repository.AlertaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    private final AlertaRepository repository;

    public AlertaService(AlertaRepository repository) {
        this.repository = repository;
    }

    public List<Alerta> listarTodos() {
        return repository.findAll();
    }

    public Optional<Alerta> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Alerta salvar(Alerta alerta) {
        return repository.save(alerta);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
