package com.example.sistemadegerenciamento.models;

public class Estoque {

    private Peca pecas;
    private OrdemCompra ordensCompra;

    public Estoque(Peca pecas, OrdemCompra ordensCompra){
        this.pecas = pecas;
        this.ordensCompra = ordensCompra;
    }
}
