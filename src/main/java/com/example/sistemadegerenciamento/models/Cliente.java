package com.example.sistemadegerenciamento.models;
import java.util.ArrayList;


/**
 * Classe responsável por armazenar dados e comportamentos do cliente.
 * */
//Alterações: coleção de ordens definido, alteração no construtor e criação de método para adicionar ordem ao cliente.
public class    Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private int clienteID;
    private static int ID = 1;

    //Ordens é uma coleção. Do tipo ArrayList.
    private ArrayList<Ordem> ordens = new ArrayList();

    /*
    * Esse método recebe uma string "nome" como entrada e retorna um valor booleano
    * indicando se o nome é válido (true) ou não (false). A validação é feita usando o
    * método "matches" da classe String, que verifica se a string corresponde à expressão regular fornecida.
    *
    * Nesse exemplo, o construtor recebe o parâmetro "nomeDePessoa" e verifica se ele corresponde à
    * expressão regular "[a-zA-Z]+". Se a validação for bem-sucedida, o construtor atribui o valor
    * ao atributo "nomeDePessoa". Caso contrário, o construtor lança uma exceção do tipo IllegalArgumentException,
    * com uma mensagem indicando que o nome de pessoa deve conter apenas letras.
    *
    * */
    public boolean validarNome(String nome) {
        return nome.matches("[a-zA-Z]+");
    }

    /*
    * Validar se o telefone contém apenas números.
    * */
    public boolean validarTelefone(String telefone) {
        return telefone.matches("\\d+");
    }


    //Como Cliente pode ser instanciado sem Ordem, ele não vem no construtor.
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
        this.clienteID = ID;
        ID = ID+1;
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
     * Método que recebe um ID de ordem e retorna a ordem do cliente de mesmo ID. Caso não haja, retorna nulo.
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

    public void addOrdem(Ordem ordem) {
        this.ordens.add(ordem);
    }

    public int getClienteID() {
        return clienteID;
    }

}


