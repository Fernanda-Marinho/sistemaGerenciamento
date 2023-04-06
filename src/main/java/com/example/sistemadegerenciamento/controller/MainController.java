package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.*;
import java.util.HashMap;

import java.util.ArrayList;

/*
* No controller, utilizaremos da classe DAO para chamar o método que dá get na classe DAO necessária.
* Por exemplo, DAO.getCliente() irá retornar um ClienteDAOImplementacao, para que possa realizar o CRUD na persistência.
* */

//falta manipular estoque, criação de técnico, criação de clientes, manipulação de ordens
// manipulação de DAO. 
public class MainController {

    public Tecnico criaTecnico(boolean adm, String nome, String senha){
        Tecnico tecnico = new Tecnico(adm, nome, senha);
        DAO.getTecnico().create(tecnico);
        return tecnico;
    }

    public boolean validaLogin(HashMap<String, Tecnico> tecnicos, String nome, String senha){
        try {
            if (tecnicos.get(nome).getSenha() == senha) {
                return true;
            }
            return false;
        } catch (NullPointerException e){
            System.out.println("Este usuário não está cadastrado.");
            return false;
        }
    }


    public static void main(String[] args) {
        MainController mainC = new MainController();
        HashMap<String, Tecnico> tecnicos = new HashMap<String, Tecnico>();
        HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
        tecnicos.put("Douglas", mainC.criaTecnico(true, "Douglas", "123456789"));
        System.out.println(mainC.validaLogin(tecnicos, "Douglas", "123456789"));
    }
}
