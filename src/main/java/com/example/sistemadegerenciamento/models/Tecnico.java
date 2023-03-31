package com.example.sistemadegerenciamento.models;
<<<<<<< HEAD
=======
import java.util.ArrayList;

//Alterações: mudança no construtor e definição da coleção de historicoOrdens
>>>>>>> fc4fb0f7e0a540b44104c7c19a4c2641d7138dc4

public class Tecnico {

    private boolean adm;
    private String nome;
    private String senha;
    private int tecnicoID;
<<<<<<< HEAD
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

=======
    private ArrayList<Ordem> historicoOrdens = new ArrayList();
    private Estoque estoque;

    //construtor
	//Um técnico não tem histórico de ordens quando é criado.
    public  Tecnico(boolean adm, String nome, String senha, int tecnicoID, Estoque estoque){
        this.adm = adm;
        this.senha = senha;
        this.tecnicoID = tecnicoID;
        this.estoque = estoque;
    }

	//Falta adicionar ordens no historico de ordens

>>>>>>> fc4fb0f7e0a540b44104c7c19a4c2641d7138dc4
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
