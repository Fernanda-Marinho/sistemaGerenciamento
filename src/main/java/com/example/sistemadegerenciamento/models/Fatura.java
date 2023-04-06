package com.example.sistemadegerenciamento.models;
import java.util.ArrayList;

//Alterações: definição da coleção de pagamentos e alteração no construtor.

public class Fatura {

    private double valorTotal;
	//Definição da coleção de pagamentos.
	private ArrayList<Pagamento> pagamentos = new ArrayList();
    private int ordemID;
    private double valorPago;
    private int faturaID;

    //construtor
	//Para gerar a fatura, adiciona um pagamento. Se for adicionar mais pagamentos, chama um método para isso.
    public Fatura(double valorTotal, int ordemID){
        this.valorTotal = valorTotal;
        this.ordemID = ordemID;
    }


    public double getValorTotal() {
        return valorTotal;
    }

    /*public Pagamento getPagamentos() {
        return pagamentos;
    }*/

    public int getOrdemID() {
        return ordemID;
    }

    public void setOrdemID(int ordemID) {
        this.ordemID = ordemID;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public int getFaturaID() {
        return faturaID;
    }

}
//faltando criar ID de fatura
//Falta adicionar novos pagamentos na coleção pagamentos: atualizar valor pago

