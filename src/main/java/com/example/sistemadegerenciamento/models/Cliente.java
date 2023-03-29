package com.example.sistemadegerenciamento.models;

public class    Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private Ordem ordens;
    private int clienteID;

    public String getNome() {
        return nome;
    }

    //construtor
    public Cliente(String nome, String endereco, String telefone, Ordem ordens, int clienteID){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.ordens = ordens;
        this.clienteID = clienteID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Ordem getOrdens() {
        return ordens;
    }

    public void setOrdens(Ordem ordens) {
        this.ordens = ordens;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }
}
