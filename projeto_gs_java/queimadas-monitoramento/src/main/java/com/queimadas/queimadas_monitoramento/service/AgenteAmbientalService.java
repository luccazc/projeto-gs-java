package com.queimadas.queimadas_monitoramento.service;

import com.queimadas.queimadas_monitoramento.domain.AgenteAmbiental;
import com.queimadas.queimadas_monitoramento.repository.AgenteAmbientalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenteAmbientalService {

    private final AgenteAmbientalRepository repository;

    public AgenteAmbientalService(AgenteAmbientalRepository repository) {
        this.repository = repository;
    }

    public List<AgenteAmbiental> listarTodos() {
        return repository.findAll();
    }

    public Optional<AgenteAmbiental> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public AgenteAmbiental salvar(AgenteAmbiental agente) {
        return repository.save(agente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
