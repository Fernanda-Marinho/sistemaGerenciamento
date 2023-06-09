package com.example.sistemadegerenciamento.DAO.tecnico;

import com.example.sistemadegerenciamento.DAO.CRUD;
import com.example.sistemadegerenciamento.models.Tecnico;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Esta interface serve para adicionar funcionalidades que o CRUD não tem, para ser implementado pelo tipo
 * de implementação da persistência.
 * */

/**
 * Interface que adiciona funcionalidades que não há no CRUD, especificando casos que só o Técnico possui.
 * */
public interface TecnicoDAO extends CRUD<Tecnico, Exception> {
    public void update(int tecnicoID, String nome, String senha);

    public HashMap<Integer, Tecnico> findMany();
    public void atualizaColecaoDoArquivo(HashMap<Integer, Tecnico> tecnicos);
    public ArrayList<Tecnico> findManyArrayList();
}
