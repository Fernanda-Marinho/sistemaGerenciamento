package com.example.sistemadegerenciamento.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdemTest {

    @Test
    void getStatus() {
    }

    @Test
    void setStatus() {
        Ordem ordem = new Ordem(1);
        ordem.setStatus(StatusOrdem.ABERTA);
        assertEquals(ordem.getStatus(), StatusOrdem.ABERTA);
        assertNotEquals(ordem.getStatus(), StatusOrdem.ESPERA);
    }

    @Test
    void getFatura() {
    }

    @Test
    void setFatura() {
    }

    @Test
    void getClienteID() {
    }

    @Test
    void setClienteID() {
    }

    @Test
    void getTecnicoID() {
    }

    @Test
    void setTecnicoID() {
    }

    @Test
    void getOrdemID() {

    }

    @Test
    void setOrdemID() {
    }

    @Test
    void getAvaliacaoFinal() {
    }

    @Test
    void setAvaliacaoFinal() {
    }
}