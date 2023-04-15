package com.example.sistemadegerenciamento.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoTest {

    @Test
    void getTipoPagamento() {
        Pagamento pagamento = new Pagamento("cartão", 50.0, 1);
        assertEquals("cartão", pagamento.getTipoPagamento());
    }

    @Test
    void getValor() {
        Pagamento pagamento = new Pagamento("cartão", 50.0, 1);
        assertEquals(50.0, pagamento.getValor(), 0.0);
    }

    @Test
    void getFaturaID() {
        Pagamento pagamento = new Pagamento("cartão", 50.0, 1);
        assertEquals(1, pagamento.getFaturaID());
    }
}