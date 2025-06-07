package com.queimadas.queimadas_monitoramento.repository;

import com.queimadas.queimadas_monitoramento.domain.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
