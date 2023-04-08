package com.example.sistemadegerenciamento.models;
import java.util.ArrayList;

//Alterações: mudança no construtor e definição da coleção de historicoOrdens

public class Tecnico {
    private boolean adm;
    private String nome;
    private String senha;
    private int tecnicoID;
    private boolean comOrdem;
    private ArrayList<Ordem> historicoOrdens = new ArrayList();
    public static int ID=1;

    //construtor
	//Um técnico não tem histórico de ordens quando é criado.
    //falta criar ID do técnico
    public  Tecnico(boolean adm, String nome, String senha){
        this.adm = adm;
        this.senha = senha;
        this.nome = nome;
        this.tecnicoID = this.ID;
        this.ID++;
    }

    public void addOrdem(Ordem ordem){
        historicoOrdens.add(ordem);
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
        if (this.comOrdem){
            return true;
        } else {
            return false;
        }
    }

}
