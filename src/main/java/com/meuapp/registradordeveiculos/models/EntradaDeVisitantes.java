package com.meuapp.registradordeveiculos.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaDeVisitantes {
    @Id
    private String id;
    //presente ou ausente
    private String statusVisita;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    //usar JPA para mapear.
    private Veiculo veiculo;
}
