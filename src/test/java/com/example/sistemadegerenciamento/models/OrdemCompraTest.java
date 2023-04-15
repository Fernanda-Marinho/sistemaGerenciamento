package com.example.sistemadegerenciamento.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdemCompraTest {

    @Test
    void getPeca() {
        Peca peca = new Peca("Peça 1", 20.0);
        OrdemCompra ordem = new OrdemCompra(peca, 5, 2.5);
        assertEquals(peca, ordem.getPeca());
    }

    @Test
    void setPeca() {
        Peca peca1 = new Peca("Peça1", 15);
        Peca peca2 = new Peca("Peça2", 40);
        OrdemCompra ordem = new OrdemCompra(peca1, 5, 2.5);
        ordem.setPeca(peca2);
        assertEquals(peca2, ordem.getPeca());
    }

    @Test
    void getQuantidade() {
        Peca peca = new Peca("Peça1", 20);
        OrdemCompra ordem = new OrdemCompra(peca, 5, 2.5);
        assertEquals(5, ordem.getQuantidade());
    }

    @Test
    void setQuantidade() {
        Peca peca = new Peca("Peça1", 20);
        OrdemCompra ordem = new OrdemCompra(peca, 5, 2.5);
        ordem.setQuantidade(10);
        assertEquals(10, ordem.getQuantidade());
    }

    @Test
    void getValorUnitario() {
        Peca peca = new Peca("Peça1", 20);
        OrdemCompra ordem = new OrdemCompra(peca, 5, 2.5);
        assertEquals(2.5, ordem.getValorUnitario(), 0.001);
    }

    @Test
    void setValorUnitario() {
        Peca peca = new Peca("Peça1", 20);
        OrdemCompra ordem = new OrdemCompra(peca, 5, 2.5);
        ordem.setValorUnitario(3.0);
        assertEquals(3.0, ordem.getValorUnitario(), 0.001);
    }
}