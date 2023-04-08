package com.example.sistemadegerenciamento.DAO.estoque;

import com.example.sistemadegerenciamento.models.Estoque;
import com.example.sistemadegerenciamento.models.OrdemCompra;
import com.example.sistemadegerenciamento.models.Peca;

import java.util.HashMap;

public interface EstoqueDAO {
    //interface de estoque
    public void addOrdemCompra(OrdemCompra ordemCompra);
    public void decrementaPeca(Peca peca);
    public HashMap verEstoque();
    public boolean verDisponibilidadeDePeca(Peca peca);
    public double gerarCustoTotalOrdensCompra();
    public String verEstoqueFormatado();
    public void devolucaoPeca(Peca peca, int quantidade);

}
