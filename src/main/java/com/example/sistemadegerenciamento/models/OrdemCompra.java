package com.example.sistemadegerenciamento.models;

public class OrdemCompra {

    private Peca peca;
    private int quantidade;
    private double valorUnitario;

<<<<<<< HEAD
    //construtor
=======
>>>>>>> fe76ec53a6cd0ffd6a2dfd142ada5540280df48a
	//Precisa receber como parâmetro o estoque para adicionar a ordem de compra nele?
    public OrdemCompra(Peca peca, int quantidade, double valorUnitario){
        this.peca = peca;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
