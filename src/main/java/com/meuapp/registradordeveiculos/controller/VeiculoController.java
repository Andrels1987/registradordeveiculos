package com.meuapp.registradordeveiculos.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

import com.meuapp.registradordeveiculos.Repositorio.VeiculoRepositorio;
import com.meuapp.registradordeveiculos.ServiceImpl.VeiculoServiceImpl;
import com.meuapp.registradordeveiculos.models.EntradaDeVisitantes;
import com.meuapp.registradordeveiculos.models.Morador;
import com.meuapp.registradordeveiculos.models.RequestData;
import com.meuapp.registradordeveiculos.models.Veiculo;
import com.meuapp.registradordeveiculos.models.Visitante;
import java.time.LocalDateTime;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/")
public class VeiculoController {

    @Autowired
    VeiculoServiceImpl veiculoServiceImpl;
    @Autowired
    VeiculoRepositorio veiculoRepositorio;
    @GetMapping("/todosveiculos")
    public ResponseEntity<List<Veiculo>> getAllVeiculos(){
        CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.HOURS).noTransform().mustRevalidate();
        List<Veiculo> veiculos =  veiculoServiceImpl.todosVeiculos();
        
        return ResponseEntity.ok().cacheControl(cacheControl).body(veiculos);
    }
    @GetMapping("veiculo/placa/{placa}")
    public ResponseEntity<Veiculo> getVeiculoPelaPlaca(@PathVariable("placa") String placa){
        Veiculo veiculo = veiculoServiceImpl.veiculoPelaPlaca(placa);
        return ResponseEntity.ok(veiculo);
    }
    @GetMapping("veiculo/id/{id}")
    public ResponseEntity<Veiculo> getVeiculoPeloId(@PathVariable("id") String id){
        Optional<Veiculo> veiculo = veiculoServiceImpl.getVeiculoPeloId(id);
        if(!veiculo.isEmpty()){
            System.out.println(veiculo.get());
            return ResponseEntity.ok(veiculo.get());            
        }
        return ResponseEntity.ok(new Veiculo());
    }

    @PostMapping("/enviarveiculo")
    public ResponseEntity<String> salvarVeiculo(@RequestBody RequestData data){
         Veiculo veiculo = new Veiculo();
        veiculo.setCor(data.cor());
        veiculo.setFoto(data.foto());
        veiculo.setMarca(data.marca());
        veiculo.setModelo(data.modelo());
        veiculo.setPlaca(data.placa());
        veiculo.setObservacao(data.observacao());
        veiculo.setVaga(data.vaga());
        veiculo.setTipoDeAutorizacao(data.tipoDeAutorizacao());
        veiculo.setStatus_de_acesso(data.statusDeAcesso());
        LocalDateTime ldt = LocalDateTime.now();
        if(data.statusDeAcesso().equals("visitante")){
            Visitante visitante = new Visitante();
            visitante.setNome(data.nomeProprietario());
            visitante.setNumeroDocumento(data.documentoProprietario());
            visitante.setBloco(data.bloco());
            visitante.setApartamento(data.apartamento());
            visitante.setHoraEntrada(ldt);
            visitante.setHoraSaida(null);
            veiculo.setMotorista(visitante);
        }else{
            Morador morador = new Morador();
            morador.setNome(data.nomeProprietario());
            morador.setApartamento(data.apartamento());
            morador.setBloco(data.bloco());
            veiculo.setMotorista(morador);
        } 
        String msg =  veiculoServiceImpl.salvarVeiculo(veiculo);
        return ResponseEntity.ok(msg);
    }
    @DeleteMapping("/deletarveiculo/{id}")
    public ResponseEntity<String> deletarVeiculo(@PathVariable String id ){
        String msg = veiculoServiceImpl.deletarVeiculo(id);
        return ResponseEntity.ok(msg);
    }
    @PutMapping("/atualizarveiculo/{id}")
    public ResponseEntity<String> atualizarVeiculo(@PathVariable String id, @RequestBody RequestData data){
        String msg = veiculoServiceImpl.atualizarVeiculo(id, data);
        return ResponseEntity.ok(msg);
        
    }
    @PostMapping("/registrarentradadevisitantes/{id}")
    public ResponseEntity<String> registrarEntrada(@PathVariable String id, @RequestBody String status){
        String msg = veiculoServiceImpl.registrarEntradaVeiculo(id, status);
        return ResponseEntity.ok(msg);
        
    }
    @PutMapping("/registrarsaidadevisitantes/{id}")
    public ResponseEntity<String> registrarSaida(@PathVariable String id){
        String msg = veiculoServiceImpl.registrarSaidaVeiculo(id);
        return ResponseEntity.ok(msg);
        
    }
    @GetMapping("/buscarregistrosdevisitas")
    public ResponseEntity<List<EntradaDeVisitantes>> buscarVisitantes(){
        List<EntradaDeVisitantes> visitas = veiculoServiceImpl.registrosDeVisitas();
        CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.HOURS).noTransform().mustRevalidate();
       
        return ResponseEntity.ok().cacheControl(cacheControl).body(visitas);
        
    }
    
}
