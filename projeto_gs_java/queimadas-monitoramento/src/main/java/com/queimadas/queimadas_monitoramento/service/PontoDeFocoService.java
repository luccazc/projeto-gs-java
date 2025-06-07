package com.queimadas.queimadas_monitoramento.service;

import com.queimadas.queimadas_monitoramento.domain.PontoDeFoco;
import com.queimadas.queimadas_monitoramento.domain.Alerta;
import com.queimadas.queimadas_monitoramento.repository.PontoDeFocoRepository;
import com.queimadas.queimadas_monitoramento.repository.AlertaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PontoDeFocoService {

    private final PontoDeFocoRepository pontoDeFocoRepository;
    private final AlertaRepository alertaRepository;

    public PontoDeFocoService(PontoDeFocoRepository pontoDeFocoRepository, AlertaRepository alertaRepository) {
        this.pontoDeFocoRepository = pontoDeFocoRepository;
        this.alertaRepository = alertaRepository;
    }

    public List<PontoDeFoco> listarTodos() {
        return pontoDeFocoRepository.findAll();
    }

    public Optional<PontoDeFoco> buscarPorId(Long id) {
        return pontoDeFocoRepository.findById(id);
    }

    public PontoDeFoco salvar(PontoDeFoco pontoDeFoco) {
        // Registra horário automaticamente, se não informado
        if (pontoDeFoco.getDataHora() == null) {
            pontoDeFoco.setDataHora(LocalDateTime.now());
        }
        PontoDeFoco salvo = pontoDeFocoRepository.save(pontoDeFoco);

        // Ao registrar um novo foco, cria automaticamente um alerta (Exemplo de regra de negócio)
        Alerta alerta = Alerta.builder()
                .descricao("Foco de queimada detectado na região " + salvo.getRegiao().getNome())
                .dataHora(LocalDateTime.now())
                .regiao(salvo.getRegiao())
                .pontoDeFoco(salvo)
                .build();
        alertaRepository.save(alerta);

        return salvo;
    }

    public void deletar(Long id) {
        pontoDeFocoRepository.deleteById(id);
    }
    
}
