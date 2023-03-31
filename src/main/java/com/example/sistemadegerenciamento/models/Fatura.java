package com.example.sistemadegerenciamento.models;
<<<<<<< HEAD
=======
import java.util.ArrayList;

//Alterações: definição da coleção de pagamentos e alteração no construtor.
>>>>>>> fc4fb0f7e0a540b44104c7c19a4c2641d7138dc4

public class Fatura {

    private double valorTotal;
<<<<<<< HEAD
    private Pagamento pagamentos;
=======
	//Definição da coleção de pagamentos.
	private ArrayList<Pagamento> pagamentos = new ArrayList();
>>>>>>> fc4fb0f7e0a540b44104c7c19a4c2641d7138dc4
    private int ordemID;
    private double valorPago;
    private int faturaID;

    //construtor
<<<<<<< HEAD
    public Fatura(double valorTotal, Pagamento pagamentos, int ordemID, double valorPago, int faturaID){
        this.valorTotal = valorTotal;
        this.pagamentos = pagamentos;
=======
	//Para gerar a fatura, adiciona um pagamento. Se for adicionar mais pagamentos, chama um método para isso.
    public Fatura(double valorTotal, Pagamento pagamento, int ordemID, double valorPago, int faturaID){
        this.valorTotal = valorTotal;
        this.pagamentos.add(pagamento);
>>>>>>> fc4fb0f7e0a540b44104c7c19a4c2641d7138dc4
        this.ordemID = ordemID;
        this.valorPago = valorPago;
        this.faturaID = faturaID;
    }

<<<<<<< HEAD
=======
	//Falta adicionar novos pagamentos na coleção pagamentos

>>>>>>> fc4fb0f7e0a540b44104c7c19a4c2641d7138dc4
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

<<<<<<< HEAD
    public Pagamento getPagamentos() {
        return pagamentos;
    }
=======
    /*public Pagamento getPagamentos() {
        return pagamentos;
    }*/
>>>>>>> fc4fb0f7e0a540b44104c7c19a4c2641d7138dc4

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
