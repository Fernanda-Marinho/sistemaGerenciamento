package com.example.sistemadegerenciamento.models;
import com.example.sistemadegerenciamento.DAO.DAO;

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
    private String idOrdemAtual;

    public static int ID=0;


    public  Tecnico(boolean adm, String nome, String senha){
        this.adm = adm;
        this.senha = senha;
        this.nome = nome;
        this.comOrdem = false;
        //Para pegar o último ID cadastrado
        if (!DAO.getTecnico().findManyArrayList().isEmpty()) {
            this.ID = DAO.getTecnico().findManyArrayList().get(DAO.getTecnico().findManyArrayList().size() - 1).getTecnicoID();
        }
        this.tecnicoID = ID+1;
    }

    /**
     * Método que adiciona uma ordem para a coleção de ordens do técnico;
     * */
    public void addOrdem(Ordem ordem){
        this.comOrdem = true;
        this.idOrdemAtual = String.valueOf(ordem.getOrdemID());
        historicoOrdens.add(ordem);
    }

    public void fechaOrdem(){
        this.comOrdem = false;
        this.idOrdemAtual = "";
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
