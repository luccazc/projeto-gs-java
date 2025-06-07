package com.queimadas.queimadas_monitoramento.service;

import com.queimadas.queimadas_monitoramento.domain.Sensor;
import com.queimadas.queimadas_monitoramento.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

     private final SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    public List<Sensor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Sensor> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Sensor salvar(Sensor sensor) {
        return repository.save(sensor);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
