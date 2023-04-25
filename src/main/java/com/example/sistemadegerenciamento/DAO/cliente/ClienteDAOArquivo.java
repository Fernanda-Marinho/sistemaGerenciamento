package com.example.sistemadegerenciamento.DAO.cliente;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.Cliente;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;

public class ClienteDAOArquivo implements Serializable {

    private static final long serialVersion = 1l;

    public void salvarArquivo() throws IOException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        HashMap<Integer, Cliente> clientes = DAO.getCliente().findMany();
        ObjectOutputStream objectOutput = new ObjectOutputStream(
                new FileOutputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\cliente\\cliente.bin")
        );
        objectOutput.writeObject(clientes);
        objectOutput.close();
    }

    public HashMap<Integer, Cliente> lerArquivo() throws IOException, ClassNotFoundException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        ObjectInputStream objectInput = new ObjectInputStream(
                new FileInputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\cliente\\cliente.bin")
        );
        HashMap<Integer, Cliente> clientes = (HashMap<Integer, Cliente>) objectInput.readObject();
        objectInput.close();
        return clientes;
    }


}
