package com.queimadas.queimadas_monitoramento.repository;

import com.queimadas.queimadas_monitoramento.domain.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}