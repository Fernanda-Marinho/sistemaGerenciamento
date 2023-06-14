package com.example.sistemadegerenciamento.models;
import com.example.sistemadegerenciamento.DAO.DAO;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Classe responsável por armazenar dados e comportamentos da fatura.
 * */
public class Fatura implements Serializable {

    private double valorTotal;
	//Definição da coleção de pagamentos.
	private ArrayList<Pagamento> pagamentos = new ArrayList();
    private Ordem ordem;
    private double valorPago;
    private static int ID = 1;
    private int faturaID;

	//Para gerar a fatura, adiciona um pagamento. Se for adicionar mais pagamentos, chama um método para isso.
    public Fatura(double valorTotal, Ordem ordem){
        this.valorTotal = valorTotal;
        this.ordem = ordem;
        this.faturaID = ID;
        this.ID++;
    }
    /**
     * Método de adicionar pagamento a fatura, incluindo método de pagamento e valor. Se o valor pago for menor que o total,
     * retorna true. Caso o valor pago fique maior que o valor total, retorna false.
     * */
    public boolean addPagamento(Pagamento pagamento){
        pagamentos.add(pagamento);
        if (this.valorPago + pagamento.getValor() <= this.valorTotal) {
            this.valorPago = this.valorPago + pagamento.getValor();
            return true;
        }
        return false;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public double getValorPago() {
        return valorPago;
    }
    /**
     * Método que retorna o valor total devedor;
     * */
    public double getSaldoDevedor(){
        return valorTotal - valorPago;
    }

    public int getFaturaID() {
        return faturaID;
    }
    public String getFaturaFormatada(){
        String string = new String();
        string = "ORDEM: " + this.ordem.getOrdemID() + "\n";
        string = string + "FATURA ID: " + this.faturaID + "\n";
        string = string + "-----DADOS CLIENTE-----" + "\n";
        string = string + "NOME: " + this.ordem.getNomeCliente() + "\n";
        string = string + "-----SERVIÇOS----- " + "\n";
        ArrayList<Servico> servicos = this.ordem.getServicos();
        for (int i=0; i<servicos.size(); i++){
            string = string + servicos.get(i).getCategoriaEmString() + ": " + servicos.get(i).getNomePeca() + " - " + servicos.get(i).getValor() + "\n";
        }
        string = string + "-----VALOR TOTAL----- " + "\n";
        string = string + "R$" + this.valorTotal + "\n";
        return string;
    }

}


