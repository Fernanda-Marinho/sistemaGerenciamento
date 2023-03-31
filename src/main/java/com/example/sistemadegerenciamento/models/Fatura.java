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
    public Fatura(double valorTotal, Pagamento pagamento, int ordemID, double valorPago, int faturaID){
        this.valorTotal = valorTotal;
        this.pagamentos.add(pagamento);
        this.ordemID = ordemID;
        this.valorPago = valorPago;
        this.faturaID = faturaID;
    }

	//Falta adicionar novos pagamentos na coleção pagamentos

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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

    public void setFaturaID(int faturaID) {
        this.faturaID = faturaID;
    }
}
