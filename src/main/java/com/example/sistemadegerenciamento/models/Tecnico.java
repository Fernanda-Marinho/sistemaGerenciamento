package com.example.sistemadegerenciamento.models;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe responsável por armazenar dados e comportamentos do técnico.
 * */

public class Tecnico implements Serializable {
    private boolean adm;
    private String nome;
    private String senha;
    private int tecnicoID;
    private boolean comOrdem;
    private ArrayList<Ordem> historicoOrdens = new ArrayList();
    public static int ID=1;

    public  Tecnico(boolean adm, String nome, String senha){
        this.adm = adm;
        this.senha = senha;
        this.nome = nome;
        this.comOrdem = false;
        this.tecnicoID = this.ID;
        this.ID++;
    }

    /**
     * Método que adiciona uma ordem para a coleção de ordens do técnico;
     * */
    public void addOrdem(Ordem ordem){
        this.comOrdem = true;
        historicoOrdens.add(ordem);
    }

    public void fechaOrdem(){
        this.comOrdem = false;
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

    public boolean isComOrdem(){
        return this.comOrdem;
    }

}
