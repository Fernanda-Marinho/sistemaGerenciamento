package com.example.sistemadegerenciamento.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PecaTest {

    @Test
    void getNome() {
        Peca peca = new Peca("Peça1", 20.0);
        assertEquals("Peça1", peca.getNome());
    }

    @Test
    void setNome() {
        Peca peca = new Peca("Peça1", 20.0);
        peca.setNome("Peça2");
        assertEquals("Peça2", peca.getNome());
    }

    @Test
    void getValor() {
        Peca peca = new Peca("Peça1", 20.0);
        assertEquals(20.0, peca.getValor(), 0.0);
    }

    @Test
    void setValor() {
        Peca peca = new Peca("Peça1", 20.0);
        peca.setValor(40.0);
        assertEquals(40.0, peca.getValor(), 0.0);
    }
}