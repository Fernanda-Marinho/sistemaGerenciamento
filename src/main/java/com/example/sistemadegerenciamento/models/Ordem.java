package com.example.sistemadegerenciamento.models;
import java.util.ArrayList;

//Alterações: modificações no construtor e definição da coleção de serviços.
public class Ordem {

	//Definição da coleção de serviços.
    private ArrayList<Servico> servicos = new ArrayList();
    private StatusOrdem status;
    private Fatura fatura;
    private int clienteID;
    private int tecnicoID;
    private int ordemID;
    private String avaliacaoFinal; //satisfação
    private static int ID=1;

    public Ordem(Servico servico, int clienteID){
        this.status = StatusOrdem.ESPERA;
        this.clienteID = clienteID;
        this.servicos.add(servico);
        this.ordemID = ID;
        this.ID++;
    }

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

    /*public Servico getServicos() {
        return servicos;
    }*/
}

//falta: ID da ordem, adicionar serviços e remover serviços, falta um método de gerar fatura
