package com.meuapp.registradordeveiculos.models;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("veiculos")
public class Veiculo {
    @Id
    private String id;
    private String placa;
    private String modelo;
    private String marca;
    private String cor;
    private String foto;
    private String vaga;
    //tipo de autorização: temporario, permanente, passageiro
    private String tipoDeAutorizacao;
    private String status_de_acesso;
    private Condutor motorista;
    private String observacao;

    public Veiculo(){

    }
    

    public Veiculo(String modelo, String cor, String marca, String placa, String proprietario, String foto,
            LocalDateTime horaEntrada, LocalDateTime horaSaida, String vaga, String isAutorizado, String isVisita,
            String observacao, String bloco, String apartamento) {
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.placa = placa;
        this.foto = foto;
        this.observacao = observacao;
        this.vaga = vaga;
    }
    public Veiculo(String id, String modelo, String cor, String marca, String placa, String proprietario, String foto,
            LocalDateTime horaEntrada, LocalDateTime horaSaida, String vaga, String isAutorizado, String isVisita,
            String observacao, String bloco, String apartamento) {
        this.id = id;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.placa = placa;
        this.foto = foto;
        this.vaga = vaga;
        this.observacao = observacao;
    }


    


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getVaga() {
        return vaga;
    }

    public void setVaga(String vaga) {
        this.vaga = vaga;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public Condutor getMotorista() {
        return motorista;
    }


    public void setMotorista(Condutor motorista) {
        this.motorista = motorista;
    }


    


    public String getStatus_de_acesso() {
        return status_de_acesso;
    }


    public void setStatus_de_acesso(String status_de_acesso) {
        this.status_de_acesso = status_de_acesso;
    }


    @Override
    public String toString() {
        return "Veiculo [id=" + id + ", modelo=" + modelo + ", cor=" + cor + ", marca=" + marca + ", placa=" + placa
                + ", foto=" + foto + ", vaga=" + vaga + ", tipo de autorização=" + tipoDeAutorizacao + ", status_de_acesso="
                + status_de_acesso + ", motorista=" + motorista + ", observacao=" + observacao + "]";
    }


    public String getTipoDeAutorizacao() {
        return tipoDeAutorizacao;
    }


    public void setTipoDeAutorizacao(String tipoDeAutorizacao) {
        this.tipoDeAutorizacao = tipoDeAutorizacao;
    }


   


    

    
    
}
