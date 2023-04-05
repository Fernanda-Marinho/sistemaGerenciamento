package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.Cliente;

import java.util.ArrayList;

/*
* No controller, utilizaremos da classe DAO para chamar o método que dá get na classe DAO necessária.
* Por exemplo, DAO.getCliente() irá retornar um ClienteDAOImplementacao, para que possa realizar o CRUD na persistência.
* */
public class MainController {
    public static void main(String[] args) {
        System.out.println("Controller criado!");
        Cliente cliente = new Cliente("Douglas", "Muchila", "75982071696");
        DAO.getCliente().create(cliente);
        cliente = new Cliente("Roberta", "Muchila", "75982071696");
        DAO.getCliente().create(cliente);
        cliente = new Cliente("Juan", "Muchila", "75982071696");
        DAO.getCliente().create(cliente);

        if (DAO.getCliente() != null) {
            ArrayList<Cliente> clientes = (ArrayList<Cliente>) DAO.getCliente().findMany();
            for (int i=0; i<clientes.size(); i++){
                System.out.println(clientes.get(i).getClienteID() + " " + clientes.get(i).getNome());
            }
        } else {
            System.out.println("Nulo!");
        }
    }
}
