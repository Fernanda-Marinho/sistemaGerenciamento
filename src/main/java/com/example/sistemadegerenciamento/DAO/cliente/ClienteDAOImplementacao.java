package com.example.sistemadegerenciamento.DAO.cliente;

import com.example.sistemadegerenciamento.models.Cliente;

import java.util.HashMap;
import java.util.List;

/**
 * Classe que implementa todos os métodos de ClienteDAO;
 * */
public class ClienteDAOImplementacao implements ClienteDAO{
    /**
     * HashMap que guarda todos os clientes, representando a implementação do DAO nesta etapa;
     * */
    HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();

    //Create seria o similar de "salvar na persistência".
    /**
     * Método que salva o cliente no HashMap clientes;
     * */
    @Override
    public Cliente create(Cliente cliente) {
        this.clientes.put(cliente.getClienteID(), cliente);
        return cliente;
    }
    /**
     * Método que encontra o cliente no HashMap;
     * */
    @Override
    public Cliente findById(int id) {
        return this.clientes.get(id);
    }
    /**
     * Método que retorna todos os clientes do HashMap;
     * */
    @Override
    public HashMap<Integer, Cliente> findMany() {
        return clientes;
    }
    /**
     * Método que atualiza os dados do cliente no HashMap;
     * */
    @Override
    public void update(int clienteID, String nome, String endereco, String telefone){
        if (clientes.get(clienteID) != null){
            Cliente cliente = clientes.get(clienteID);
            cliente.setNome(nome);
            cliente.setTelefone(telefone);
            cliente.setEndereco(endereco);
            clientes.put(clienteID, cliente);
        }
    }
    /**
     * Método que deleta o cliente do HashMap;
     * */
    @Override
    public void delete(int clienteID) throws Exception {
        if (clientes.get(clienteID) != null){
            clientes.remove(clienteID);
        }
    }
    /**
     * Método que limpa todo o HashMap;
     * */
    @Override
    public void deleteMany() {
        clientes.clear();
    }
}
