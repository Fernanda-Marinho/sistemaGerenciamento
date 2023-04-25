package com.example.sistemadegerenciamento.DAO.estoque;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.Peca;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;

public class EstoqueDAOArquivo implements Serializable {

    private static final long serialVersion = 1l;

    public void salvarArquivo() throws IOException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        HashMap<Peca, Integer> pecas = DAO.getEstoque().verEstoque();
        ObjectOutputStream objectOutput = new ObjectOutputStream(
                new FileOutputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\estoque\\estoque.bin")
        );
        objectOutput.writeObject(pecas);
        objectOutput.close();
    }

    public HashMap<Peca, Integer> lerArquivo() throws IOException, ClassNotFoundException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        ObjectInputStream objectInput = new ObjectInputStream(
                new FileInputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\estoque\\estoque.bin")
        );
        HashMap<Peca, Integer> pecas = (HashMap<Peca, Integer>) objectInput.readObject();
        objectInput.close();
        return pecas;
    }


}
