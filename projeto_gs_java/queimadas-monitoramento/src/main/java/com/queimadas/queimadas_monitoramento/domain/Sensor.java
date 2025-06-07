package com.queimadas.queimadas_monitoramento.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class Sensor {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificador;

    private String tipo; // Ex: "Calor", "Fumaça"

    @ManyToOne
    private Regiao regiao;
}
