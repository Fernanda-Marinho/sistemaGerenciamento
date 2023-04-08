package com.example.sistemadegerenciamento.models;
import java.util.ArrayList;
import java.util.Calendar;

//Alterações: modificações no construtor e definição da coleção de serviços.
public class Ordem {

	//Definição da coleção de serviços.
    private ArrayList<Servico> servicos = new ArrayList();
    private StatusOrdem status;
    private Fatura fatura;
    private int clienteID;
    private int tecnicoID;
    private int ordemID;
    private long tempoMedioDeServicos;
    private String avaliacaoFinal; //satisfação
    private static int ID=1;

    public Ordem(int clienteID){
        this.status = StatusOrdem.ESPERA;
        this.clienteID = clienteID;
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

    public void addServico(Servico servico){
        this.servicos.add(servico);
    }

    public void removerServico(Servico servico){
        for (int i=0; i<servicos.size(); i++){
            if (servicos.get(i) == servico){
                servicos.remove(servico);
                return;
            }
        }
    }
    public void finalizarServico(Servico servico, int avaliacaoCliente){
        for (int i=0; i<servicos.size(); i++){
            if (servicos.get(i) == servico){
                servicos.get(i).finalizarServico(avaliacaoCliente);
                return;
            }
        }
    }
    public double gerarValorTotal(){
        double valor = 0.0;
        for (int i=0; i<this.servicos.size(); i++){
            valor += servicos.get(i).getValor();
        }
        return valor;
    }

    public Fatura gerarFatura(){
        Fatura fatura = new Fatura(gerarValorTotal(), this.getOrdemID());
        this.fatura = fatura;
        return fatura;
    }
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

//falta: ID da ordem, adicionar serviços e remover serviços, falta um método de gerar fatura
