package com.example.sistemadegerenciamento.DAO.ordem;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.Ordem;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;

public class OrdemDAOArquivo implements Serializable {

    private static final long serialVersion = 1l;

    public void salvarArquivoOrdensEmAberto() throws IOException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        HashMap<Integer, Ordem> pecas = DAO.getOrdem().findManyEmAbertoHashMap();
        ObjectOutputStream objectOutput = new ObjectOutputStream(
                new FileOutputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\ordem\\ordemEmAberto.bin")
        );
        objectOutput.writeObject(pecas);
        objectOutput.close();
    }

    public HashMap<Integer, Ordem> lerArquivoOrdensEmAberto() throws IOException, ClassNotFoundException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        ObjectInputStream objectInput = new ObjectInputStream(
                new FileInputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\ordem\\ordemEmAberto.bin")
        );
        HashMap<Integer, Ordem> ordens = (HashMap<Integer, Ordem>) objectInput.readObject();
        objectInput.close();
        return ordens;
    }

    public void salvarArquivoOrdensEmEspera() throws IOException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        HashMap<Integer, Ordem> pecas = DAO.getOrdem().findManyEmEsperaHashMap();
        ObjectOutputStream objectOutput = new ObjectOutputStream(
                new FileOutputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\ordem\\ordemEmEspera.bin")
        );
        objectOutput.writeObject(pecas);
        objectOutput.close();
    }

    public HashMap<Integer, Ordem> lerArquivoOrdensEmEspera() throws IOException, ClassNotFoundException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        ObjectInputStream objectInput = new ObjectInputStream(
                new FileInputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\ordem\\ordemEmEspera.bin")
        );
        HashMap<Integer, Ordem> ordens = (HashMap<Integer, Ordem>) objectInput.readObject();
        objectInput.close();
        return ordens;
    }

    public void salvarArquivoOrdensCanceladas() throws IOException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        HashMap<Integer, Ordem> pecas = DAO.getOrdem().findManyCanceladasHashMap();
        ObjectOutputStream objectOutput = new ObjectOutputStream(
                new FileOutputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\ordem\\ordemCancelada.bin")
        );
        objectOutput.writeObject(pecas);
        objectOutput.close();
    }

    public HashMap<Integer, Ordem> lerArquivoOrdensCanceladas() throws IOException, ClassNotFoundException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        ObjectInputStream objectInput = new ObjectInputStream(
                new FileInputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\ordem\\ordemCancelada.bin")
        );
        HashMap<Integer, Ordem> ordens = (HashMap<Integer, Ordem>) objectInput.readObject();
        objectInput.close();
        return ordens;
    }

    public void salvarArquivoOrdensFinalizadas() throws IOException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        HashMap<Integer, Ordem> pecas = DAO.getOrdem().findManyFinalizadasHashMap();
        ObjectOutputStream objectOutput = new ObjectOutputStream(
                new FileOutputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\ordem\\ordemFinalizada.bin")
        );
        objectOutput.writeObject(pecas);
        objectOutput.close();
    }

    public HashMap<Integer, Ordem> lerArquivoOrdensFinalizadas() throws IOException, ClassNotFoundException {
        String diretorioAtual = Paths.get(".").toAbsolutePath().normalize().toString();
        ObjectInputStream objectInput = new ObjectInputStream(
                new FileInputStream(diretorioAtual + "\\src\\main\\java\\com\\example\\sistemadegerenciamento\\DAO\\ordem\\ordemFinalizada.bin")
        );
        HashMap<Integer, Ordem> ordens = (HashMap<Integer, Ordem>) objectInput.readObject();
        objectInput.close();
        return ordens;
    }



}
