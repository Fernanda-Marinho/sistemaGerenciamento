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
