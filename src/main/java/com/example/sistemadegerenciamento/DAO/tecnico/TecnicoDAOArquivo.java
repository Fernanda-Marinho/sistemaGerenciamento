package com.example.sistemadegerenciamento.DAO.tecnico;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.Tecnico;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;

public class TecnicoDAOArquivo implements Serializable {

    private static final long serialVersion = 1l;

    public void salvarArquivo() throws IOException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        HashMap<Integer, Tecnico> tecnicos = DAO.getTecnico().findMany();
        ObjectOutputStream objectOutput = new ObjectOutputStream(
                new FileOutputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\tecnico\\tecnico.bin")
        );
        objectOutput.writeObject(tecnicos);
        objectOutput.close();
    }

    public HashMap<Integer, Tecnico> lerArquivo() throws IOException, ClassNotFoundException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        ObjectInputStream objectInput = new ObjectInputStream(
                new FileInputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\tecnico\\tecnico.bin")
        );
        HashMap<Integer, Tecnico> tecnicos = (HashMap<Integer, Tecnico>) objectInput.readObject();
        objectInput.close();
        return tecnicos;
    }


}
