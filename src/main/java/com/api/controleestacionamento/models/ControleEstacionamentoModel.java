package com.api.controleestacionamento.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "TB_VAGA_ESTACIONAMENTO")
public class ControleEstacionamentoModel implements Serializable{
    private static final long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // o auto gera de forma automatica (nao precisa enviar o id)
    private UUID id; // UUID é um tipo de identificador distribuido (mais recomendado)
    @Column(nullable = false, unique = true, length = 10)
    private String numeroVagaEstacionamento;
    @Column(nullable = false, unique = true, length = 7)
    private String placaVeiculo;
    @Column(nullable = false,length = 70)
    private String marcaVeiculo;
    @Column(nullable = false,length = 70)
    private String modeloCarro;
    @Column(nullable = false,length = 70)
    private String corCarro;
    @Column(nullable = false)
    private LocalDateTime dataRegistro;
    @Column(nullable = false, length = 130)
    private String nomeResponsavel;
    @Column(nullable = false, length = 30)
    private String apartamento;
    @Column(nullable = false, length = 30)
    private String bloco;
//serialId é o controle das conversões feito pela jvn
//a classe implementa o serializeble, realacionado as conversões feitas por debaixo dos panos (de obj java - bytes) para ser salvbo no banco de dados

    public ControleEstacionamentoModel() {
    }

    public ControleEstacionamentoModel(UUID id, String numeroVagaEstacionamento, String placaVeiculo,
            String marcaVeiculo, String modeloCarro, String corCarro, LocalDateTime dataRegistro,
            String nomeResponsavel, String apartamento, String bloco) {
        this.id = id;
        this.numeroVagaEstacionamento = numeroVagaEstacionamento;
        this.placaVeiculo = placaVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.modeloCarro = modeloCarro;
        this.corCarro = corCarro;
        this.dataRegistro = dataRegistro;
        this.nomeResponsavel = nomeResponsavel;
        this.apartamento = apartamento;
        this.bloco = bloco;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNumeroVagaEstacionamento() {
        return numeroVagaEstacionamento;
    }
    public void setNumeroVagaEstacionamento(String numeroVagaEstacionamento) {
        this.numeroVagaEstacionamento = numeroVagaEstacionamento;
    }
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }
    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }
    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }
    public String getModeloCarro() {
        return modeloCarro;
    }
    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }
    public String getCorCarro() {
        return corCarro;
    }
    public void setCorCarro(String corCarro) {
        this.corCarro = corCarro;
    }
    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }
    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }
    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
    public String getApartamento() {
        return apartamento;
    }
    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }
    public String getBloco() {
        return bloco;
    }
    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

}
