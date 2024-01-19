package com.meuapp.registradordeveiculos.ServiceImpl;

import java.util.Optional;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meuapp.registradordeveiculos.Repositorio.EntradaDeVeiculoRepositorio;
import com.meuapp.registradordeveiculos.Repositorio.VeiculoRepositorio;
import com.meuapp.registradordeveiculos.Service.VeiculoService;
import com.meuapp.registradordeveiculos.models.Condutor;
import com.meuapp.registradordeveiculos.models.EntradaDeVisitantes;
import com.meuapp.registradordeveiculos.models.RequestData;
import com.meuapp.registradordeveiculos.models.Veiculo;
import com.mongodb.lang.NonNull;

@Service
public class VeiculoServiceImpl implements VeiculoService {
    @Autowired
    VeiculoRepositorio veiculoRepositorio;
    @Autowired
    EntradaDeVeiculoRepositorio entradaDeVeiculoRepositorio;

    @Override
    public List<Veiculo> todosVeiculos() {
        return veiculoRepositorio.findAll();
    }

    @Override
    public Veiculo veiculoPelaPlaca(String placa) {
        return veiculoRepositorio.findVeiculoByPlaca(placa);
    }

    public Optional<Veiculo> getVeiculoPeloId(String id) {
        if (id != null) {
            return veiculoRepositorio.findById(id);
        }
        return Optional.empty();

    }

    @Override
    public String deletarVeiculo(@NonNull String id) {
        if (id == null) {
            return "nenhum id inserido";
        }
        veiculoRepositorio.deleteById(id);
        return "tudo certo";
    }

    @Override
    public String salvarVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            return "nenhum veiculo inserido";
        }
        veiculoRepositorio.save(veiculo);
        return "tudo certo";
    }

    @Override
    public String atualizarVeiculo(@NonNull String id, @NonNull RequestData data) {
        Veiculo v = new Veiculo();
        Condutor condutor = new Condutor();
        if (id == null) {
            return "nenhum id inserido";
        }

        v = veiculoRepositorio.findById(id).get();

        if (v != null) {
            condutor.setApartamento(data.apartamento());
            condutor.setBloco(data.bloco());
            condutor.setNome(data.nomeProprietario());
            condutor.setNumeroDocumento(data.documentoProprietario());
            v.setMotorista(condutor);
            v.setCor(data.cor());
            v.setFoto(data.foto());
            v.setMarca(data.marca());
            v.setModelo(data.modelo());
            v.setPlaca(data.placa());
            v.setObservacao(data.observacao());
            v.setVaga(data.vaga());
            v.setTipoDeAutorizacao(data.tipoDeAutorizacao());
            v.setStatus_de_acesso(data.statusDeAcesso());
            Veiculo vSalvo = veiculoRepositorio.save(v);
            if (vSalvo.getId() != null) {
                return "veiculo de placa: " + vSalvo.getPlaca() + " salvo";
            }
        }
        return "veiculo não encontrado";
    }

    @Override
    public String registrarEntradaVeiculo(@NonNull String id, String statusVisita) {
        EntradaDeVisitantes ev = new EntradaDeVisitantes();
        System.out.println(statusVisita);
        if(id != null){
            Veiculo v = veiculoRepositorio.findById(id).get();            
            ev.setVeiculo(v);            
            ev.setStatusVisita(statusVisita);
            ev.setHoraEntrada(LocalDateTime.now());
            ev.setHoraSaida(null);
            EntradaDeVisitantes o = entradaDeVeiculoRepositorio.save(ev);
            if(o.getId() != null){
                return "Entrada registrada";
            }
        }
        return "nenhum obj salvo";
    }
    @Override
    public String registrarSaidaVeiculo(String id) {
        Optional<EntradaDeVisitantes> Optionalev = Optional.empty();
        if(id != null){
            Optionalev = entradaDeVeiculoRepositorio.findById(id);
        }
        if(Optionalev.isPresent()){
            EntradaDeVisitantes ev = Optionalev.get();
            ev.setHoraSaida(LocalDateTime.now());
            ev.setStatusVisita("ausente");
            entradaDeVeiculoRepositorio.save(ev);
            return "Saida do veiculo de placa " + ev.getVeiculo().getPlaca() + "atualizada";
        }
        
    return "Registro não encontrado";
}
    @Override
    public List<EntradaDeVisitantes> registrosDeVisitas() {
        List<EntradaDeVisitantes> ev = entradaDeVeiculoRepositorio.findAll();
        return ev;
}

}
