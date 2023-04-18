package com.example.sistemadegerenciamento.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//Não ta aceitando nome com espaços e nem com acento
class ClienteTest {

    @Test
    void validarNome() {
        Cliente cliente = new Cliente("Maria da Silva", "Endereço, 123", "99999999");
        assertTrue(cliente.validarNome("Maria da Silva"));
        assertFalse(cliente.validarNome("Pedro123"));
    }

    @Test
    void validarTelefone() {
        Cliente cliente = new Cliente("Maria", "Endereço, 123", "99999999");
        assertTrue(cliente.validarTelefone("7512345678"));
        assertFalse(cliente.validarTelefone("123-456-789"));
    }
    @Test
    void getNome() {
        Cliente cliente = new Cliente("Maria", "Endereço, 123", "99999999");
        assertEquals("Maria", cliente.getNome());
    }

    @Test
    void setNome() {
        Cliente cliente = new Cliente("Maria", "Endereço, 123", "99999999");
        cliente.setNome("Maria");
        assertEquals("Maria", cliente.getNome());
        assertThrows(IllegalArgumentException.class, () -> cliente.setNome("Pedro123"));
    }

    @Test
    void getEndereco() {
        Cliente cliente = new Cliente("Maria", "Endereço do Cliente, 123", "99999999");
        assertEquals("Endereço do Cliente, 123", cliente.getEndereco());
    }

    @Test
    void setEndereco() {
        Cliente cliente = new Cliente("Maria", "Endereço do Cliente, 123", "99999999");
        cliente.setEndereco("Endereço do Cliente, 123");
        assertEquals("Endereço do Cliente, 123", cliente.getEndereco());
    }

    @Test
    void getTelefone() {
        Cliente cliente = new Cliente("Maria", "Endereço, 123", "99999999");
        assertEquals("99999999", cliente.getTelefone());
    }

    @Test
    void setTelefone() {
        Cliente cliente = new Cliente("Maria", "Endereço, 123", "99999999");
        cliente.setTelefone("91234567");
        assertEquals("91234567", cliente.getTelefone());
        assertThrows(IllegalArgumentException.class, () -> cliente.setTelefone("912-345-678"));
    }

    @Test
    void getOrdem() {
        Cliente cliente = new Cliente("Maria", "Endereço, 123", "99999999");
        Ordem ordem = new Ordem(10);
        cliente.addOrdem(ordem);
        assertEquals(cliente.getOrdem(1).getOrdemID(), 1);
    }

    @Test
    void getOrdens() {
        Cliente cliente = new Cliente("Maria", "Endereço, 123", "99999999");
        Ordem ordem = new Ordem(10);
        cliente.addOrdem(ordem);
        Ordem ordem2 = new Ordem(10);
        cliente.addOrdem(ordem2);
        ArrayList<Ordem> ordens = new ArrayList<>();
        ordens.add(ordem);
        ordens.add(ordem2);
        assertEquals(cliente.getOrdens(), ordens);
    }

    @Test
    void addOrdem() {
        Cliente cliente = new Cliente("Maria", "Endereço, 123", "99999999");
        Ordem ordem = new Ordem(10);
        cliente.addOrdem(ordem);
        assertEquals(cliente.getOrdem(1).getOrdemID(), 1);
    }

}