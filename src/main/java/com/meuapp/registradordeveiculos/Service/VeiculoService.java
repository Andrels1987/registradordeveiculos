package com.meuapp.registradordeveiculos.Service;

import java.util.List;

import com.meuapp.registradordeveiculos.models.EntradaDeVisitantes;
import com.meuapp.registradordeveiculos.models.RequestData;
import com.meuapp.registradordeveiculos.models.Veiculo;
public interface VeiculoService {
    public List<Veiculo> todosVeiculos();
    public Veiculo veiculoPelaPlaca(String placa);
    public String deletarVeiculo(String id);
    public String salvarVeiculo(Veiculo veiculo);
    public String atualizarVeiculo(String id, RequestData veiculo);
    public String registrarEntradaVeiculo(String id, String statusVisita);
    public String registrarSaidaVeiculo(String id);
    public List<EntradaDeVisitantes> registrosDeVisitas();
}
