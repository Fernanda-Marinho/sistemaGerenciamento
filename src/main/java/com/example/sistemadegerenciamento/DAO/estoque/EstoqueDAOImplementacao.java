package com.example.sistemadegerenciamento.DAO.estoque;

import com.example.sistemadegerenciamento.models.OrdemCompra;
import com.example.sistemadegerenciamento.models.Peca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EstoqueDAOImplementacao implements EstoqueDAO {
    //implementação da interface de estoque
    private HashMap<Peca, Integer> quantidadePecas = new HashMap<Peca, Integer>();
    private ArrayList<OrdemCompra> ordensCompra = new ArrayList();
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
    @Override
    public void decrementaPeca(Peca peca){
        if (quantidadePecas.containsKey(peca)){
            quantidadePecas.put(peca, quantidadePecas.get(peca)-1);
        }
    }
    @Override
    public HashMap verEstoque(){
        return quantidadePecas;
    }
    public boolean verDisponibilidadeDePeca(Peca peca){
        if (quantidadePecas.containsKey(peca)){
            if (quantidadePecas.get(peca) > 0){
                return true;
            }
        }
        return false;
    }

    public double gerarCustoTotalOrdensCompra(){
        double valorTotal=0;
        for (int i=0; i<ordensCompra.size(); i++){
            valorTotal = valorTotal + (ordensCompra.get(i).getValorUnitario() * ordensCompra.get(i).getQuantidade());
        }
        return valorTotal;
    }

    public String verEstoqueFormatado(){
        String estoquef = new String("NOME\tQNTD\tVALOR UNI.\n");
        for (Map.Entry<Peca, Integer> valor : quantidadePecas.entrySet()){
            estoquef = estoquef + valor.getKey().getNome() + " - " + valor.getValue() + " - " + valor.getKey().getValor() + ";\n";
        }
        return estoquef;
    }
}
