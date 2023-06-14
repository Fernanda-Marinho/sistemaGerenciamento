package com.example.sistemadegerenciamento.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FaturaTest {

    @Test
    void addPagamento() {
        Ordem ordem = new Ordem(new Cliente("Fulano", "Rua", "123"));
        Fatura fatura = ordem.gerarFatura();
        Pagamento pagamento = new Pagamento("Cartão", 123.9, fatura.getFaturaID());
        fatura.addPagamento(pagamento);
        assertEquals(ordem.getFatura().getPagamentos().get(0), pagamento);
    }

    @Test
    void getValorTotal() {
        double valorTotal = 200.0;
        Fatura fatura = new Fatura(valorTotal,new Ordem(new Cliente("Fulano", "Rua", "123")));
        assertEquals(valorTotal, fatura.getValorTotal(), 0.0);
    }

    @Test
    void getPagamentos() {
        Pagamento pag1 = new Pagamento("Credito", 200.0, 1);
        Pagamento pag2 = new Pagamento("Debito", 100.0, 2);
        Fatura fatura = new Fatura(300,new Ordem(new Cliente("Fulano", "Rua", "123")));
        fatura.addPagamento(pag1);
        fatura.addPagamento(pag2);
        ArrayList<Pagamento> pags = fatura.getPagamentos();
        assertEquals(2, pags.size());
        assertEquals(pag1, pags.get(0));
        assertEquals(pag2, pags.get(1));

    }

    @Test
    void getOrdemID() {
        int Id = 123;
        Fatura fatura = new Fatura(100,new Ordem(new Cliente("Fulano", "Rua", "123")));
        assertEquals(Id, fatura.getFaturaID());
    }





    @Test
    void getValorPago() {
    }

    @Test
    void getSaldoDevedor() {
    }

    @Test
    void getFaturaID() {
    }
}