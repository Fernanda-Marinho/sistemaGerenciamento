package com.example.sistemadegerenciamento.DAO.ordem;

import com.example.sistemadegerenciamento.DAO.CRUD;
import com.example.sistemadegerenciamento.models.Ordem;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Esta interface serve para adicionar funcionalidades que o CRUD não tem, para ser implementado pelo tipo
 * de implementação da persistência.
 * */
/**
 * Interface que adiciona funcionalidades que não há no CRUD, especificando casos que só a Ordem possui.
 * */

public interface OrdemDAO extends CRUD<Ordem, Exception> {

    public void cancelarOrdem(int ordemID);
    public Ordem finalizarOrdem(int ordemID);
    public long gerarTempoMedioDeOrdensFinalizadas();
    public String gerarMediaSatisfacaoPorOrdem();
    public String verOrdensEmEspera();
    public void abrirOrdem(int ordemID, int tecnicoID);
    public Ordem findByIdFinalizada(int ordemID);
    public Ordem findByIdCancelada(int ordemID);
    public Ordem findByIdAberta(int ordemID);
    public HashMap<Integer, Ordem> findManyEmEsperaHashMap();
    public HashMap<Integer, Ordem> findManyEmAbertoHashMap();
    public HashMap<Integer, Ordem> findManyFinalizadasHashMap();
    public HashMap<Integer, Ordem> findManyCanceladasHashMap();
    public ArrayList<Ordem> findManyEmEspera();
    public ArrayList<Ordem> findManyEmAberto();
    public ArrayList<Ordem> findManyCanceladas();
    public ArrayList<Ordem> findManyFinalizadas();
    public void atualizaColecaoDoArquivoOrdensAbertas(HashMap<Integer, Ordem> ordens);
    public void atualizaColecaoDoArquivoOrdensEmEspera(HashMap<Integer, Ordem> ordens);
    public void atualizaColecaoDoArquivoOrdensFinalizadas(HashMap<Integer, Ordem> ordens);
    public void atualizaColecaoDoArquivoOrdensCanceladas(HashMap<Integer, Ordem> ordens);
}
