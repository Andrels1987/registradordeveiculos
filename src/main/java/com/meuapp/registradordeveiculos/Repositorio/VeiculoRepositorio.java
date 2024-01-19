package com.meuapp.registradordeveiculos.Repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.meuapp.registradordeveiculos.models.Veiculo;

public interface VeiculoRepositorio extends MongoRepository<Veiculo, String>{
    @Query("{'placa': ?0}")
    public Veiculo findVeiculoByPlaca(String placa);
}
