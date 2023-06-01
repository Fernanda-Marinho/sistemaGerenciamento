package com.example.sistemadegerenciamento.models;
import com.example.sistemadegerenciamento.DAO.DAO;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Classe responsável por armazenar dados e comportamentos do cliente.
 * */
//Alterações: coleção de ordens definido, alteração no construtor e criação de método para adicionar ordem ao cliente.
public class Cliente implements Serializable {
    private String nome;
    private String endereco;
    private String telefone;
    private int clienteID;

    public static int ID = 0;
    private ArrayList<Ordem> ordens = new ArrayList();

    /**
     * Método que valida o nome do cliente, permitindo apenas letras minúsculas e maiúsculas e espaços.
     * */
    public boolean validarNome(String nome) {

        return nome.matches("[a-zA-Z ]+");
    }
    /**
     * Método que valida o telefone do cliente, permitindo apenas números.
     * */
    public boolean validarTelefone(String telefone) {
        return telefone.matches("\\d+");
    }

    public Cliente(String nome, String endereco, String telefone){
        if (validarNome(nome) == true){
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("O nome de pessoa deve conter apenas letras.");
        }
        if (validarTelefone(telefone) == true){
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("O número de telefone deve ter apenas números.");
        }
        this.endereco = endereco;
        //Para pegar o último ID cadastrado
        if (!DAO.getCliente().findManyArrayList().isEmpty()) {
            this.ID = DAO.getCliente().findManyArrayList().get(DAO.getCliente().findManyArrayList().size() - 1).getClienteID();
        }
        this.clienteID = ID+1;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (validarNome(nome) == true){
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("O nome de pessoa deve conter apenas letras.");
        }
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
        if (validarTelefone(telefone) == true){
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("O número de telefone deve ter apenas números.");
        }
    }
    /**
     * Método que retorna uma ordem através do ID;
     * */
    public Ordem getOrdem(int ordemID) {
        for (int i=0; i<this.ordens.size(); i++){
            if (this.ordens.get(i).getOrdemID() == ordemID){
                return this.ordens.get(i);
            }
        }
        return null;
    }

    public ArrayList<Ordem> getOrdens(){
        return this.ordens;
    }
    /**
     * Método que adiciona uma ordem ao ArrayList de ordens do cliente;
     * */
    public void addOrdem(Ordem ordem) {
        this.ordens.add(ordem);
    }

    public int getClienteID() {
        return clienteID;
    }

}


