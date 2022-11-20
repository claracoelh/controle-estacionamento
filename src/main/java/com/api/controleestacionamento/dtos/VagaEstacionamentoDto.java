package com.api.controleestacionamento.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class VagaEstacionamentoDto {
    //campos que o cliente vai gerar precisam estar inseridos aqui
    // aqui fazemos a verificação se o clinte seguiu os parametros estipulados para então add no banco de dads
    @NotBlank //verificar se a string não é nula ou vazia
    private String numeroVagaEstacionamento;
    @NotBlank
    @Size(max = 7) //limitação de max min caracter 
    private String placaVeiculo;
    @NotBlank
    private String marcaVeiculo;
    @NotBlank
    private String modeloCarro;
    @NotBlank
    private String corCarro;
    @NotBlank
    private String nomeResponsavel;
    @NotBlank
    private String apartamento;
    @NotBlank
    private String bloco;
    
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
    public String getmodeloCarro() {
        return modeloCarro;
    }
    public void setmodeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }
    public String getcorCarro() {
        return corCarro;
    }
    public void setcorCarro(String corCarro) {
        this.corCarro = corCarro;
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
