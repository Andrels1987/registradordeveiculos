package com.meuapp.registradordeveiculos.models;


public class Morador extends Condutor {

    @Override
    public String toString() {
        return "Morador [Nome= " + getNome() + " bloco= " + getBloco() + "apartamento= " + getApartamento() + "Documento= " + getNumeroDocumento() + "]";
    }



    
}
