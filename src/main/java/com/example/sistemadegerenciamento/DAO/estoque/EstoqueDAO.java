package com.example.sistemadegerenciamento.DAO.estoque;

import com.example.sistemadegerenciamento.models.OrdemCompra;
import com.example.sistemadegerenciamento.models.Peca;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface que adiciona funcionalidades que não há no CRUD, especificando casos que só o Estoque possui.
 * */
public interface EstoqueDAO {
    //interface de estoque
    public void addOrdemCompra(OrdemCompra ordemCompra);
    public void decrementaPeca(Peca peca);
    public HashMap verEstoque();
    public boolean verDisponibilidadeDePeca(Peca peca);
    public double gerarCustoTotalOrdensCompra();
    public String verEstoqueFormatado();
    public void devolucaoPeca(Peca peca, int quantidade);
    public void atualizaColecaoDoArquivo(HashMap<Peca, Integer> pecas);
    public ArrayList<Peca> findManyPecas();

}
