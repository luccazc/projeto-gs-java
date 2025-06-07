package com.queimadas.queimadas_monitoramento.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class PontoDeFoco {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private String intensidade; // Ex: "Alto", "Médio", "Baixo"

    @ManyToOne
    private Sensor sensor;

    @ManyToOne
    private Regiao regiao;


}
