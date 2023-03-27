package com.example.sistemadegerenciamento.models;

public class Tecnico {

    private boolean adm;
    private String nome;
    private String senha;
    private int tecnicoID;
    private Ordem historicoOrdens;
    private Estoque estoque;

    //construtor
    public  Tecnico(boolean adm, String nome, String senha, int tecnicoID, Ordem historicoOrdens, Estoque estoque){
        this.adm = adm;
        this.senha = senha;
        this.tecnicoID = tecnicoID;
        this.historicoOrdens = historicoOrdens;
        this.estoque = estoque;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTecnicoID() {
        return tecnicoID;
    }

    public void setTecnicoID(int tecnicoID) {
        this.tecnicoID = tecnicoID;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}
