package com.example.sistemadegerenciamento.models;

import java.util.Calendar;
public class Servico {

    private CategoriaServico categoria;
    private double valor;
    private Calendar horarioAbertura;
    private Calendar horarioFinalizacao;
    private double avaliacaoCliente;
    private int ordemID;
    private Peca peca;
    private String descricao;

    //construtor
    public Servico(CategoriaServico categoria, double valor, Calendar horarioAbertura, Calendar horarioFinalizacao, double avaliacaoCliente, int ordemID, Peca peca, String descricao){
	//A avalição do cliente não pode ser no momento da instância. Só após finalizar o serviço/ordem.
	//Possa ser que não tenha uma descrição?
    public Servico (CategoriaServico categoria, double valor, Calendar horarioAbertura, Calendar horarioFinalizacao, int ordemID, Peca peca, String descricao){
        this.categoria = categoria;
        this.valor = valor;
        this.horarioAbertura = horarioAbertura;
        this.horarioFinalizacao = horarioFinalizacao;
        this.avaliacaoCliente = avaliacaoCliente;
        this.ordemID = ordemID;
        this.peca = peca;
        this.descricao = descricao;
    }

    public CategoriaServico getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaServico categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(Calendar horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public Calendar getHorarioFinalizacao() {
        return horarioFinalizacao;
    }

    public void setHorarioFinalizacao(Calendar horarioFinalizacao) {
        this.horarioFinalizacao = horarioFinalizacao;
    }

    public double getAvaliacaoCliente() {
        return avaliacaoCliente;
    }

    public void setAvaliacaoCliente(double avaliacaoCliente) {
        this.avaliacaoCliente = avaliacaoCliente;
    }

    public int getOrdemID() {
        return ordemID;
    }

    public void setOrdemID(int ordemID) {
        this.ordemID = ordemID;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
