package com.meuapp.registradordeveiculos.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.meuapp.registradordeveiculos.models.EntradaDeVisitantes;

public interface EntradaDeVeiculoRepositorio extends MongoRepository<EntradaDeVisitantes, String>  {
    
}
