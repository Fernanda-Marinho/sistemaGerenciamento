package com.example.sistemadegerenciamento.models;
import java.util.ArrayList;

//Alterações: coleção de ordens definido, alteração no construtor e criação de método para adicionar ordem ao cliente.

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

	//Ordens é uma coleção. Do tipo ArrayList.
	private ArrayList<Ordem> ordens = new ArrayList();
    private int clienteID;

    //construtor
	//Como Cliente pode ser instanciado sem Ordem, ele não vem no construtor.
    public Cliente(String nome, String endereco, String telefone, int clienteID){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.clienteID = clienteID;
    }

	public String getNome() {
        return nome;
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
    /*public Ordem getOrdem(int ordemID) {
        return this.ordens.get(ordemID);
    }*/

    public void addOrdem(Ordem ordem) {
        this.ordens.add(ordem);
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }
}
