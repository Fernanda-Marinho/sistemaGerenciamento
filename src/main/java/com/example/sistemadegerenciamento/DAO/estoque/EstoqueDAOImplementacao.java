package com.example.sistemadegerenciamento.DAO.estoque;

import com.example.sistemadegerenciamento.models.OrdemCompra;
import com.example.sistemadegerenciamento.models.Peca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Classe que implementa todos os métodos de EstoqueDAO;
 * */
public class EstoqueDAOImplementacao implements EstoqueDAO {
    /**
     * HashMap que guarda todos as pecas, representando a implementação do DAO nesta etapa;
     * */
    private HashMap<Peca, Integer> quantidadePecas = new HashMap<Peca, Integer>();
    /**
     * Arraylist que guarda todas as ordens de compra realizadas;
     * */
    private ArrayList<OrdemCompra> ordensCompra = new ArrayList();
    /**
     * Método que adiciona ordem de compra no estoque, contabilizando a quantidade da entrada de peças;
     * */
    @Override
    public void addOrdemCompra(OrdemCompra ordemCompra){
        ordensCompra.add(ordemCompra);
        if (quantidadePecas.containsKey(ordemCompra.getPeca())){
            int qntdNova = ordemCompra.getQuantidade();
            int qntdAtual = quantidadePecas.get(ordemCompra.getPeca());
            int qntdTotal = qntdNova + qntdAtual;
            quantidadePecas.put(ordemCompra.getPeca(), qntdTotal);
        } else {
            quantidadePecas.put(ordemCompra.getPeca(), ordemCompra.getQuantidade());
        }
    }
    /**
     * Método que decrementa peça do estoque de acordo com a utilização em serviço;
     * */
    @Override
    public void decrementaPeca(Peca peca){
        if (quantidadePecas.containsKey(peca)){
            quantidadePecas.put(peca, quantidadePecas.get(peca)-1);
        }
    }
    /**
     * Método que retorna o HashMap do estoque, contabilizando todas as peças e suas quantidades;
     * */
    @Override
    public HashMap verEstoque(){
        return quantidadePecas;
    }
    /**
     * Método que verifica a disponibilidade da peça no estoque, ou seja, se há peça no estoque;
     * */
    public boolean verDisponibilidadeDePeca(Peca peca){
        if (quantidadePecas.containsKey(peca)){
            if (quantidadePecas.get(peca) > 0){
                return true;
            }
        }
        return false;
    }
    /**
     * Método que retorna o custo total das ordens de compras;
     * */
    public double gerarCustoTotalOrdensCompra(){
        double valorTotal=0;
        for (int i=0; i<ordensCompra.size(); i++){
            valorTotal = valorTotal + (ordensCompra.get(i).getValorUnitario() * ordensCompra.get(i).getQuantidade());
        }
        return valorTotal;
    }
    /**
     * Método que retorna uma String formatada do estoque, havendo o nome, quantidade e valor unitário de cada peça;
     * */
    public String verEstoqueFormatado(){
        String estoquef = new String("NOME\tQNTD\tVALOR UNI.\n");
        for (Map.Entry<Peca, Integer> valor : quantidadePecas.entrySet()){
            estoquef = estoquef + valor.getKey().getNome() + "   \t" + valor.getValue() + "   \t" + valor.getKey().getValor() + ";\n";
        }
        return estoquef;
    }
    /**
     * Método que devolve a peça para o estoque caso a ordem seja cancelada;
     * */
    public void devolucaoPeca(Peca peca, int quantidade){
        quantidadePecas.put(peca, quantidadePecas.get(peca) + quantidade);
    }
}
