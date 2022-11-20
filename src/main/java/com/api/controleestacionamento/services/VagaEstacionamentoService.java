package com.api.controleestacionamento.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.controleestacionamento.models.ControleEstacionamentoModel;
import com.api.controleestacionamento.repositories.VagaEstacionamentoRepository;

@Service
public class VagaEstacionamentoService {
    
    //ponto de injeção do repository - acionamento do repository sempre que tiver transações do banco (em vez do controler ir direto para o controler, ira ter contato com o repository)
    //@Autowired //injetar uma dependencia
    final VagaEstacionamentoRepository vagaEstacionamentoRepository; // final = constante

    public VagaEstacionamentoService(VagaEstacionamentoRepository vagaEstacionamentoRepository) {
        this.vagaEstacionamentoRepository = vagaEstacionamentoRepository; // criação do objeto para usabilidade de funcionalidades (nesse3 caso crud)
    }

    @Transactional //medotos construtivos ou destrutivos (com delção ou salvamento em cascata) é indicado usar esse comentario para evitar erros
    public ControleEstacionamentoModel save(ControleEstacionamentoModel controleEstacionamentoModel) {
        return vagaEstacionamentoRepository.save(controleEstacionamentoModel);
    }
 
    // declarando os metodos dos ifs
    public boolean existsByPlacaVeiculo(String placaVeiculo){
        return vagaEstacionamentoRepository.existsByPlacaVeiculo(placaVeiculo);
    }
    
    public boolean existsByNumeroVagaEstacionamento(String numeroVagaEstacionamento){
        return vagaEstacionamentoRepository.existsByNumeroVagaEstacionamento(numeroVagaEstacionamento); 
    }
      public boolean existsByApartamentoAndBloco(String apartamento, String Bloco){
        return vagaEstacionamentoRepository.existsByApartamentoAndBloco(apartamento, Bloco);
      }
    //GetAll
    public List<ControleEstacionamentoModel> findAll() {
        return vagaEstacionamentoRepository.findAll();
    }

    public Optional<ControleEstacionamentoModel> findById(UUID id) {
        return vagaEstacionamentoRepository.findById(id);
    }



    //Delete
    @Transactional
    public void delete(ControleEstacionamentoModel controleEstacionamentoModel) {
        vagaEstacionamentoRepository.delete(controleEstacionamentoModel);
    }
}
