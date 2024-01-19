package com.meuapp.registradordeveiculos.models;


public record RequestEntradaDoVeiculoData(String modelo, String cor, String marca,
String placa, String nomeProprietario, String foto, String vaga,
String tipoDeAutorizacao, String statusDeAcesso, String observacao, String bloco,
String apartamento, String documentoProprietario, String statusVisita) {

}
