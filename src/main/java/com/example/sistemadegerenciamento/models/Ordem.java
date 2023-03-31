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

	//Como a ordem pode ter nenhum técnico, então não deve ser colocado no construtor. Adiciona um serviço na construção. Se for adicionar mais depois, utiliza um método para isso.
	//Dúvida: a ordem precisa ter 0..1 fatura?
	//Como a ordem pode ter nenhuma fatura, então não deve entrar no construtor.
	//Status começa em aberta
	//Não tem como ter avaliação final no momento da instância da ordem. Somente quando é finalizada.
    public Ordem(Servico servico, int clienteID, int ordemID){
        this.servicos = servicos;
		//Status começa em aberta
        this.status = StatusOrdem.ABERTA;
        this.clienteID = clienteID;
        this.ordemID = ordemID;
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
