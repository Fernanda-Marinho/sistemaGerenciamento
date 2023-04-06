package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.CategoriaServico;
import com.example.sistemadegerenciamento.models.Cliente;
import com.example.sistemadegerenciamento.models.Fatura;
import com.example.sistemadegerenciamento.models.Servico;

import java.util.ArrayList;

/*
* No controller, utilizaremos da classe DAO para chamar o método que dá get na classe DAO necessária.
* Por exemplo, DAO.getCliente() irá retornar um ClienteDAOImplementacao, para que possa realizar o CRUD na persistência.
* */

//falta manipular estoque, criação de técnico, criação de clientes, manipulação de ordens
// manipulação de DAO. 
public class MainController {
    public static void main(String[] args) {
        Fatura fatura = new Fatura(19.0, 1);
        System.out.println(fatura.getFaturaID());
        Fatura fatura2 = new Fatura(19.0, 2);
        System.out.println(fatura2.getFaturaID());
        Fatura fatura3 = new Fatura(19.0, 3);
        System.out.println(fatura3.getFaturaID());

        Servico servico = new Servico(CategoriaServico.MONTAGEM,12.5,002,null,"nada");
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
