package com.example.sistemadegerenciamento.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FaturaTest {

    @Test
    void addPagamento() {
        Ordem ordem = new Ordem(1);
        Fatura fatura = ordem.gerarFatura();
        Pagamento pagamento = new Pagamento("Cartão", 123.9, fatura.getFaturaID());
        fatura.addPagamento(pagamento);
        assertEquals(ordem.getFatura().getPagamentos().get(0), pagamento);
    }

    @Test
    void getValorTotal() {
    }

    @Test
    void getPagamentos() {
    }

    @Test
    void getOrdemID() {
    }

    @Test
    void setOrdemID() {
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