package com.queimadas.queimadas_monitoramento.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder


public class Alerta {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private LocalDateTime dataHora;

    @ManyToOne
    private Regiao regiao;

    @ManyToOne
    private PontoDeFoco pontoDeFoco;

}
