package com.example.sistemadegerenciamento.models;

public class OrdemCompra {

    private Peca peca;
    private int quantidade;
    private double valorUnitario;

    //construtor
<<<<<<< HEAD
=======
	//Precisa receber como parâmetro o estoque para adicionar a ordem de compra nele?
>>>>>>> fc4fb0f7e0a540b44104c7c19a4c2641d7138dc4
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
