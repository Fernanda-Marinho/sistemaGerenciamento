package com.example.sistemadegerenciamento.DAO.cliente;

import com.example.sistemadegerenciamento.DAO.CRUD;
import com.example.sistemadegerenciamento.models.Cliente;

import java.util.HashMap;

/*
* Esta interface serve para adicionar funcionalidades que o CRUD não tem, para ser implementado pelo tipo
* de implementação da persistência.
* */

public interface ClienteDAO extends CRUD<Cliente, Exception> {

    public void update(int clienteID, String nome, String endereco, String telefone);
    public HashMap<Integer, Cliente> findMany();

}
