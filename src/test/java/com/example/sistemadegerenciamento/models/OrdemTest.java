package com.example.sistemadegerenciamento.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdemTest {

    @Test
    void getStatus() {
        Ordem ordem = new Ordem(1);
        assertEquals(StatusOrdem.ESPERA, ordem.getStatus());
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
        Ordem ordem = new Ordem(1);
        assertNull(ordem.getFatura());
    }

    @Test
    void getClienteID() {
        Ordem ordem = new Ordem(1);
        assertEquals(1, ordem.getClienteID());
    }

    @Test
    void getTecnicoID() {
        Ordem ordem = new Ordem(1);
        ordem.setTecnicoID(10);
        assertEquals(10, ordem.getTecnicoID());
    }

    @Test
    void setTecnicoID() {
        int clienteID = 1;
        int tecnicoID = 2;
        Ordem ordem = new Ordem(clienteID);
        ordem.setTecnicoID(tecnicoID);
        int result = ordem.getTecnicoID();
        assertEquals(tecnicoID, result);
    }

    @Test
    void getOrdemID() {
        int clienteID = 1;
        Ordem ordem = new Ordem(clienteID);
        assertEquals(1, ordem.getOrdemID());
    }

    @Test
    void getAvaliacaoFinal() {
        Ordem ordem = new Ordem(1);
        ordem.setAvaliacaoFinal("OK");
        assertEquals("OK", ordem.getAvaliacaoFinal());
    }

    @Test
    void setAvaliacaoFinal() {
        Ordem ordem = new Ordem(1);
        String novaAvaliacao = "OK";
        ordem.setAvaliacaoFinal(novaAvaliacao);
        assertEquals(novaAvaliacao, ordem.getAvaliacaoFinal());
    }


}