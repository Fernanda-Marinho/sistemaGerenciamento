package com.example.sistemadegerenciamento.DAO.cliente;

import com.example.sistemadegerenciamento.models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImplementacao implements ClienteDAO{

    ArrayList<Cliente> clientes = new ArrayList<>();
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
    public List<Cliente> findMany() {
        return null;
    }

    @Override
    public void update(Cliente obj) throws Exception {

    }

    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public void deleteMany() {

    }
}
