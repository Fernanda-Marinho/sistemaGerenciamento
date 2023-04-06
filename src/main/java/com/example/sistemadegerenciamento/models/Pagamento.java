package com.example.sistemadegerenciamento.models;

public class Pagamento {

    private String tipoPagamento;
    private double valor;
    private int faturaID;

    //construtor
    public Pagamento(String tipoPagamento, double valor, int faturaID){
        this.tipoPagamento = tipoPagamento;
        this.valor = valor;
        this.faturaID = faturaID;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public double getValor() {
        return valor;
    }

    public int getFaturaID() {
        return faturaID;
    }

}
