package com.example.sistemadegerenciamento.models;
import com.example.sistemadegerenciamento.DAO.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Classe responsável por armazenar dados e comportamentos da ordem.
 * */
public class Ordem implements Serializable {

	//Definição da coleção de serviços.
    private ArrayList<Servico> servicos = new ArrayList();
    private StatusOrdem status;
    private Fatura fatura;
    private int clienteID;
    private String nomeCliente;
    private String servicosEmString;
    private int tecnicoID;
    private int ordemID;
    private long tempoMedioDeServicos;
    private String avaliacaoFinal; //satisfação
    private static int ID=0;

    public Ordem(int clienteID){
        this.status = StatusOrdem.ESPERA;
        this.clienteID = clienteID;
        this.nomeCliente = DAO.getCliente().findById(clienteID).getNome();

        //Para pegar o último ID cadastrado
        if (!DAO.getOrdem().findManyEmEspera().isEmpty()) {
            this.ID = DAO.getOrdem().findManyEmEspera().get(DAO.getOrdem().findManyEmEspera().size() - 1).getOrdemID();
        } else if (!DAO.getOrdem().findManyEmAberto().isEmpty()) {
            this.ID = DAO.getOrdem().findManyEmAberto().get(DAO.getOrdem().findManyEmAberto().size() - 1).getOrdemID();
        } else if (!DAO.getOrdem().findManyFinalizadas().isEmpty()){
            this.ID = DAO.getOrdem().findManyFinalizadas().get(DAO.getOrdem().findManyFinalizadas().size() - 1).getOrdemID();
        } else if (!DAO.getOrdem().findManyCanceladas().isEmpty()){
            this.ID = DAO.getOrdem().findManyCanceladas().get(DAO.getOrdem().findManyCanceladas().size() - 1).getOrdemID();
        }
        this.ordemID = ID+1;
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

    /**
     * Método que adiciona o serviço no ArrayList de serviços;
     * */
    public void addServico(Servico servico){
        if (servicos == null){
            this.servicosEmString = servico.getCategoria().toString();
        } else {
            this.servicosEmString = ", " + servico.getCategoria().toString();
        }
        this.servicos.add(servico);
    }

    /**
     * Método que remove o serviço informado do ArrayList;
     * */
    public void removerServico(Servico servico){
        for (int i=0; i<servicos.size(); i++){
            if (servicos.get(i) == servico){
                servicos.remove(servico);
                return;
            }
        }
    }
    /**
     * Método que finaliza o serviço informado da ArrayList;
     * */
    public void finalizarServico(Servico servico, int avaliacaoCliente){
        for (int i=0; i<servicos.size(); i++){
            if (servicos.get(i) == servico){
                servicos.get(i).finalizarServico(avaliacaoCliente);
                return;
            }
        }
    }
    /**
     * Método que retorna o valor total de todos os serviços da ArrayList;
     * */
    public double gerarValorTotal(){
        double valor = 0.0;
        for (int i=0; i<this.servicos.size(); i++){
            valor += servicos.get(i).getValor();
        }
        return valor;
    }
    /**
     * Método que gera e retorna a fatura da ordem;
     * */
    public Fatura gerarFatura(){
        Fatura fatura = new Fatura(gerarValorTotal(), this.getOrdemID());
        this.fatura = fatura;
        return fatura;
    }
    /**
     * Método que verifica o tempo de espera de cada serviço e retorna uma média deles;
     * */
    public void gerarTempoMedioDeServicos(){
        long tempoTotal = 0;
        long diferencaMinutos;
        long tempoMedio=0;
        int quantidadeAvaliados=0;
        //Para cada serviço já finalizado, calcular tempo e adicionar em tempoTotal.
        for (int i=0; i<this.servicos.size(); i++){
            diferencaMinutos = 0;
            if (this.servicos.get(i).isFinalizado()){
                Calendar fechamento = servicos.get(i).getHorarioFechamento();
                Calendar abertura = servicos.get(i).getHorarioAbertura();
                diferencaMinutos = (fechamento.getTimeInMillis() - abertura.getTimeInMillis())/60000;
                tempoTotal = tempoTotal + diferencaMinutos;
                quantidadeAvaliados++;
            }
        }
        if (quantidadeAvaliados > 0){
            tempoMedio = tempoTotal / quantidadeAvaliados;
        } else {
            tempoMedio = 0;
        }
        this.tempoMedioDeServicos = tempoMedio;
    }

    /**
     * Método que gera uma média da safistação de todos os serviços da ordem;
     * */
    public double gerarMediaDeSatisfacaoDoCliente(){
        double media;
        int soma = 0;
        int qntd = 0;
        for (int i=0; i<servicos.size(); i++){
            if (servicos.get(i).isFinalizado()){
                soma = soma + servicos.get(i).getAvaliacaoCliente();
                qntd++;
            }
        }
        return (double) soma/qntd;
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

    public ArrayList<Servico> getServicos() {
        return this.servicos;
    }

    public long getTempoMedioDeServicos(){
        return tempoMedioDeServicos;
    }
}