package com.example.sistemadegerenciamento.models;
import java.util.ArrayList;

//Alterações: definição da coleção de pagamentos e alteração no construtor.

public class Fatura {

    private double valorTotal;
	//Definição da coleção de pagamentos.
	private ArrayList<Pagamento> pagamentos = new ArrayList();
    private int ordemID;
    private double valorPago;
    private static int ID = 1;
    private int faturaID;

	//Para gerar a fatura, adiciona um pagamento. Se for adicionar mais pagamentos, chama um método para isso.
    public Fatura(double valorTotal, int ordemID){
        this.valorTotal = valorTotal;
        this.ordemID = ordemID;
        this.faturaID = ID;
        this.ID++;
    }
    /**
     * Método de adicionar pagamento. Se o valor pago for menor que o total,
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

    public int getOrdemID() {
        return ordemID;
    }

    public void setOrdemID(int ordemID) {
        this.ordemID = ordemID;
    }

    public double getValorPago() {
        return valorPago;
    }

    public double getSaldoDevedor(){
        return valorTotal - valorPago;
    }

    public int getFaturaID() {
        return faturaID;
    }

}


