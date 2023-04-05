package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.Cliente;

/*
* No controller, utilizaremos da classe DAO para chamar o método que dá get na classe DAO necessária.
* Por exemplo, DAO.getCliente() irá retornar um ClienteDAOImplementacao, para que possa realizar o CRUD na persistência.
* */
public class MainController {
    public static void main(String[] args) {
        System.out.println("Controller criado!");
        Cliente cliente = new Cliente("Douglas", "Muchila", "75982071696", 10);
        DAO.getCliente().create(cliente);
        cliente = new Cliente("Roberta", "Muchila", "75982071696", 11);
        DAO.getCliente().create(cliente);
        if (DAO.getCliente().findById(11) != null) {
            System.out.println(DAO.getCliente().findById(10).getNome());
            System.out.println(DAO.getCliente().findById(11).getNome());
        } else {
            System.out.println("Nulo!");
        }
    }
}
