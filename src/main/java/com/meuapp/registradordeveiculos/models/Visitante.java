package com.meuapp.registradordeveiculos.models;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visitante extends Condutor {
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    /* public Visitante(Boolean estaAutorizado, LocalDateTime horaEntrada, 
            LocalDateTime horaSaida, String nome, String numeroDocumento, char bloco, String apartamento) {
        super(nome, numeroDocumento, bloco, apartamento);
        this.estaAutorizado = estaAutorizado;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }
    public Visitante(){
        super();
    }
    
    public Boolean getEstaAutorizado() {
        return estaAutorizado;
    }
    
    public void setEstaAutorizado(Boolean estaAutorizado) {
        this.estaAutorizado = estaAutorizado;
    }
    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }
    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }
    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    } */
    @Override
    public String toString() {
        return "Visitante [ Nome=" + getNome()  + ", horaEntrada=" + horaEntrada + ", horaSaida="
                + horaSaida + "]";
    }

    


}
