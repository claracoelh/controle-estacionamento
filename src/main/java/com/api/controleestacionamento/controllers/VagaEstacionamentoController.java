package com.api.controleestacionamento.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
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

import com.api.controleestacionamento.dtos.VagaEstacionamentoDto;
import com.api.controleestacionamento.models.ControleEstacionamentoModel;
import com.api.controleestacionamento.services.VagaEstacionamentoService;

//API rest
@RestController
@CrossOrigin(origins = "*", maxAge = 3600) // acesso de qualquer fonte
@RequestMapping("/parking-spot")//
public class VagaEstacionamentoController {
    
    //ponto de injeção do service no controller
    final VagaEstacionamentoService vagaEstacionamentoService;

    public VagaEstacionamentoController(VagaEstacionamentoService vagaEstacionamentoService) {
        this.vagaEstacionamentoService = vagaEstacionamentoService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarVagaEstacionamento(@RequestBody @Valid VagaEstacionamentoDto vagaEstacionamentoDto){
        //verificações sobre as placas, vagas, apartamento/bloco
        if(vagaEstacionamentoService.existsByPlacaVeiculo(vagaEstacionamentoDto.getPlacaVeiculo())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Placa do veiculo já esta em uso!");
        }

        if(vagaEstacionamentoService.existsByNumeroVagaEstacionamento(vagaEstacionamentoDto.getNumeroVagaEstacionamento())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Essa vaga já esta em uso!");
        }

        if(vagaEstacionamentoService.existsByApartamentoAndBloco(vagaEstacionamentoDto.getApartamento(), vagaEstacionamentoDto.getBloco())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: A vaga de estacionamento já esta registrada para esse apartamento/bloco!");
        }

        var controleEstacionamentoModel = new ControleEstacionamentoModel();
        BeanUtils.copyProperties(vagaEstacionamentoDto, controleEstacionamentoModel);
        controleEstacionamentoModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(vagaEstacionamentoService.save(controleEstacionamentoModel));
    
        //1- se recebe como parametro o metodo DPO pq precisa dos parametros passados pelo cliente, vindo como JaSON
        //2- @valid é necessarias para que as validações do dpo funcionem
        //3- BeanUtils - conversao de dpo para model para salvar no banco de dados
        //4 - vaga de estacionamento salva com as informações passadas pelo cliente
    }
    // retorna uma listagem dos models no get
    // se nao tiver nenhuma listagem a mensagem vai vazia
    @GetMapping
    public ResponseEntity<List<ControleEstacionamentoModel>> getAllNumeroVagaEstacionamento(){
        return ResponseEntity.status(HttpStatus.OK).body(vagaEstacionamentoService.findAll());
    }
    // precisa passar o id para a URI obter as informações
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneNumeroVagaEstacionamento(@PathVariable(value = "id") UUID id){
        Optional<ControleEstacionamentoModel> controleVagaEstacionamentoOptional = vagaEstacionamentoService.findById(id);
        if (!controleVagaEstacionamentoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(controleVagaEstacionamentoOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNumeroVagaEstacionamento(@PathVariable(value = "id") UUID id){
        Optional<ControleEstacionamentoModel> controleVagaEstacionamentoOptional = vagaEstacionamentoService.findById(id);
        if (!controleVagaEstacionamentoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada.");
        }
        vagaEstacionamentoService.delete(controleVagaEstacionamentoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Vaga de estacionamento foi deletada.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateNumeroVagaEstacionamento(@PathVariable(value = "id") UUID id, @RequestBody @Valid VagaEstacionamentoDto vagaEstacionamentoDto){
        System.out.println(id);
        Optional<ControleEstacionamentoModel> controleVagaEstacionamentoOptional = vagaEstacionamentoService.findById(id);
        System.out.print(controleVagaEstacionamentoOptional);
        if (!controleVagaEstacionamentoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada.");
        }
        var controleEstacionamentoModel = controleVagaEstacionamentoOptional.get();
        controleEstacionamentoModel.setNumeroVagaEstacionamento(vagaEstacionamentoDto.getNumeroVagaEstacionamento());
        controleEstacionamentoModel.setNumeroVagaEstacionamento(vagaEstacionamentoDto.getPlacaVeiculo());
        controleEstacionamentoModel.setNumeroVagaEstacionamento(vagaEstacionamentoDto.getmodeloCarro());
        controleEstacionamentoModel.setNumeroVagaEstacionamento(vagaEstacionamentoDto.getcorCarro());
        controleEstacionamentoModel.setNumeroVagaEstacionamento(vagaEstacionamentoDto.getNomeResponsavel());
        controleEstacionamentoModel.setNumeroVagaEstacionamento(vagaEstacionamentoDto.getApartamento());
        controleEstacionamentoModel.setNumeroVagaEstacionamento(vagaEstacionamentoDto.getBloco());
        return ResponseEntity.status(HttpStatus.OK).body(vagaEstacionamentoService.save(controleEstacionamentoModel));

    }
}

