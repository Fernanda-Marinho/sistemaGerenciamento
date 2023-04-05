package com.example.sistemadegerenciamento.DAO;

import com.example.sistemadegerenciamento.DAO.cliente.ClienteDAO;
import com.example.sistemadegerenciamento.DAO.cliente.ClienteDAOImplementacao;

public class DAO {
    private static ClienteDAO clienteDAO;
    public static ClienteDAO getCliente() {
        if (clienteDAO == null) {
            clienteDAO = new ClienteDAOImplementacao();
        }
        return clienteDAO;
    }
}
