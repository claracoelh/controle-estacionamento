package com.api.controleestacionamento.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.controleestacionamento.models.ControleEstacionamentoModel;

@Repository
public interface VagaEstacionamentoRepository extends JpaRepository<ControleEstacionamentoModel, UUID>{

  boolean existsByApartamentoAndBloco(String apartamento, String bloco);
  boolean existsByNumeroVagaEstacionamento(String numeroVagaEstacionamento);
  boolean existsByPlacaVeiculo(String placaVeiculo); 
}
