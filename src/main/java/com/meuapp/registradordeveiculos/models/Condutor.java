package com.meuapp.registradordeveiculos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Condutor {
    private  String nome;
    private String numeroDocumento;
    private String bloco;
    private String apartamento;      
} 
