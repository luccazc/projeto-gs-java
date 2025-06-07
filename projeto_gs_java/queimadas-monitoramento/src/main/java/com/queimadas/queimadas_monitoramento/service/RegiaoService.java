package com.queimadas.queimadas_monitoramento.service;

import com.queimadas.queimadas_monitoramento.domain.Regiao;
import com.queimadas.queimadas_monitoramento.repository.RegiaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegiaoService {

    private final RegiaoRepository repository;

    public RegiaoService(RegiaoRepository repository) {
        this.repository = repository;
    }

    public List<Regiao> listarTodos() {
        return repository.findAll();
    }

    public Optional<Regiao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Regiao salvar(Regiao regiao) {
        return repository.save(regiao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
