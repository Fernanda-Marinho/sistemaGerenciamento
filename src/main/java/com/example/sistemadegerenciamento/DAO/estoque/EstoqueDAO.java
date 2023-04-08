package com.example.sistemadegerenciamento.DAO.estoque;

import com.example.sistemadegerenciamento.models.OrdemCompra;
import com.example.sistemadegerenciamento.models.Peca;

import java.util.HashMap;

public interface EstoqueDAO {
    public void addOrdemCompra(OrdemCompra ordemCompra);
    public void decrementaPeca(Peca peca);
    public HashMap verEstoque();
    public boolean verDisponibilidadeDePeca(Peca peca);
    public double gerarCustoTotalOrdensCompra();
    public String verEstoqueFormatado();

}
