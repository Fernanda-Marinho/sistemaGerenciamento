package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;

import java.io.IOException;

public class SaveData {
    public static void saveAllData() throws IOException {
        DAO.getClienteDAOArquivo().salvarArquivo();
        DAO.getEstoqueDAOArquivo().salvarArquivo();
        DAO.getTecnicoDAOArquivo().salvarArquivo();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensCanceladas();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensEmAberto();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensEmEspera();
        DAO.getOrdemDAOArquivo().salvarArquivoOrdensFinalizadas();
    }
}
