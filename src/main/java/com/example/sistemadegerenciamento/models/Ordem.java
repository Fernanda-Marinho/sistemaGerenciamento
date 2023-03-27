package com.example.sistemadegerenciamento.models;

public class Ordem {

    private Servico servicos;
    private StatusOrdem status;
    private Fatura fatura;
    private int clienteID;
    private int tecnicoID;
    private int ordemID;
    private String avaliacaoFinal; //satisfação

    public StatusOrdem getStatus() {
        return status;
    }

    public void setStatus(StatusOrdem status) {
        this.status = status;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getTecnicoID() {
        return tecnicoID;
    }

    public void setTecnicoID(int tecnicoID) {
        this.tecnicoID = tecnicoID;
    }

    public int getOrdemID() {
        return ordemID;
    }

    public void setOrdemID(int ordemID) {
        this.ordemID = ordemID;
    }

    public String getAvaliacaoFinal() {
        return avaliacaoFinal;
    }

    public void setAvaliacaoFinal(String avaliacaoFinal) {
        this.avaliacaoFinal = avaliacaoFinal;
    }

    public Servico getServicos() {
        return servicos;
    }
}
