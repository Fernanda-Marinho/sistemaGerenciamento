package com.example.sistemadegerenciamento.DAO.cliente;

import com.example.sistemadegerenciamento.models.Cliente;

import java.util.ArrayList;

public class ClienteDAOImplementacao implements ClienteDAO{
    ArrayList<Cliente> clientes = new ArrayList<>();

    //Create seria o similar de "salvar na persistência".
    @Override
    public Cliente create(Cliente cliente) {
        this.clientes.add(cliente);
        return cliente;
    }

    @Override
    public Cliente findById(int id) {
        for (int i=0; i<clientes.size(); i++){
            if (clientes.get(i).getClienteID() == id){
                return clientes.get(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<Cliente> findMany() {
        return clientes;
    }

    public void update(Cliente cliente) throws Exception{}
    //Update seria o similar de "atualizar na persistência".
    @Override
    public void update(Cliente cliente, String nome, String endereco, String telefone, int id){
        for (int i=0; i<clientes.size(); i++){
            if (clientes.get(i) == cliente){
                clientes.get(i).setNome(nome);
                clientes.get(i).setEndereco(endereco);
                clientes.get(i).setTelefone(telefone);
                clientes.get(i).setClienteID(id);
            }
        }
    }

    @Override
    public void delete(int id) throws Exception {
        for (int i=0; i<clientes.size(); i++){
            if (clientes.get(i).getClienteID() == id){
                clientes.remove(clientes.get(i));
            }
        }
    }

    @Override
    public void deleteMany() {
        clientes.clear();
    }
}
