package com.example.sistemadegerenciamento.DAO.cliente;

import com.example.sistemadegerenciamento.models.Cliente;

import java.util.HashMap;
import java.util.List;

public class ClienteDAOImplementacao implements ClienteDAO{
    HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();

    //Create seria o similar de "salvar na persistência".
    @Override
    public Cliente create(Cliente cliente) {
        this.clientes.put(cliente.getClienteID(), cliente);
        return cliente;
    }

    @Override
    public Cliente findById(int id) {
        if (this.clientes.get(id) != null)
            return this.clientes.get(id);
        else
            return null;
    }

    @Override
    public HashMap<Integer, Cliente> findMany() {
        return clientes;
    }

    public void update(Cliente cliente) throws Exception{}

    //Update seria o similar de "atualizar na persistência".
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

    @Override
    public void delete(int clienteID) throws Exception {
        if (clientes.get(clienteID) != null){
            clientes.remove(clienteID);
        }
    }

    @Override
    public void deleteMany() {
        clientes.clear();
    }
}
