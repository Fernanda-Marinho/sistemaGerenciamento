package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
import com.example.sistemadegerenciamento.models.Cliente;
import com.example.sistemadegerenciamento.models.Tecnico;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {
    @Test
    void criaTecnico() {
        Tecnico tec = new Tecnico(false, "lalala", "12345");
        DAO.getTecnico().create(tec);
        int id = tec.getTecnicoID();
        assertEquals(tec, DAO.getTecnico().findById(id));
    }
    @Test
    void deletaTecnico() throws Exception {
        Tecnico tec = new Tecnico(true, "lalala", "12345");
        DAO.getTecnico().create(tec);
        Tecnico tec2 = new Tecnico(false, "lelele", "12345");
        DAO.getTecnico().create(tec2);
        int id = tec2.getTecnicoID();
        if (tec.isAdm()){
            DAO.getTecnico().delete(id);
        }
        assertNotEquals(tec2, DAO.getTecnico().findById(id));
    }
    @Test
    void atualizaTecnico() {
        Tecnico tecnico = new Tecnico(true, "admin", "admin");
        Tecnico tecnico2 = new Tecnico(false, "robert", "blabla");
        DAO.getTecnico().create(tecnico);
        DAO.getTecnico().create(tecnico2);
        if (tecnico.isAdm())
            DAO.getTecnico().update(tecnico2.getTecnicoID(), "manuela", "bleble");
        HashMap<Integer, Tecnico> dict = DAO.getTecnico().findMany();
        System.out.println(dict.get(1).getNome());
        System.out.println(dict.get(2).getNome());

    }

    @Test
    void buscaTodosTecnicos() {
        Tecnico tec = new Tecnico(false, "Roberto", "12345");
        Tecnico tec2 = new Tecnico(true, "Juliana Passos", "admin");
        DAO.getTecnico().create(tec);
        DAO.getTecnico().create(tec2);
        HashMap <Integer, Tecnico> tecnicos = new HashMap<>();
        tecnicos.put(tec.getTecnicoID(), tec);
        tecnicos.put(tec2.getTecnicoID(), tec2);
        assertEquals(DAO.getTecnico().findMany(), tecnicos);
    }

    @Test
    void buscaTecnico() {
        Tecnico tec = new Tecnico(false, "Maria", "mdemdime");
        DAO.getTecnico().create(tec);
        assertEquals(tec, DAO.getTecnico().findById(tec.getTecnicoID()));
    }

    @Test
    void validaLogin() {
        Tecnico tec = new Tecnico(false, "Maria", "mdemdime");
        DAO.getTecnico().create(tec);
        String login = new String("Maria");
        String senha = new String("mdemdime");
        assertEquals(senha, DAO.getTecnico().findById(tec.getTecnicoID()).getSenha());
        assertEquals(login, DAO.getTecnico().findById(tec.getTecnicoID()).getNome());
    }

    @Test
    void criaCliente() {
        Cliente cliente = new Cliente("Douglas", "rua bla bla", "759812312");
        DAO.getCliente().create(cliente);
        assertEquals(DAO.getCliente().findById(cliente.getClienteID()), cliente);
    }

    @Test
    void atualizaCliente() {
        Cliente cliente = new Cliente("Douglas", "rua bla bla", "759812312");
        DAO.getCliente().create(cliente);
        DAO.getCliente().update(1, "Douglas Oliveira", "rua ble ble", "750293432");
        assertEquals(DAO.getCliente().findById(1).getNome(), "Douglas Oliveira");
        assertEquals(DAO.getCliente().findById(1).getEndereco(), "rua ble ble");
        assertEquals(DAO.getCliente().findById(1).getTelefone(), "750293432");
        assertNotEquals(DAO.getCliente().findById(1).getNome(), "Douglas");
    }

    @Test
    void deletaCliente() throws Exception {
        Cliente cliente = new Cliente("Douglas", "rua bla bla", "759812312");
        DAO.getCliente().create(cliente);
        DAO.getCliente().delete(cliente.getClienteID());
        assertEquals(null, DAO.getCliente().findById(1));
    }

    @Test
    void buscaTodosClientes() {
        Cliente cliente = new Cliente("Douglas", "rua bla bla", "759812312");
        Cliente cliente2 = new Cliente("Jorge Silva", "malamamalam", "24234324");
        HashMap<Integer, Cliente> clientes = new HashMap<>();
        clientes.put(cliente.getClienteID(), cliente);
        clientes.put(cliente2.getClienteID(), cliente2);
        DAO.getCliente().create(cliente);
        DAO.getCliente().create(cliente2);
        assertEquals(clientes, DAO.getCliente().findMany());
    }

    @Test
    void buscaCliente() {
        Cliente cliente = new Cliente("Douglas", "rua bla bla", "759812312");
        DAO.getCliente().create(cliente);
        assertEquals(cliente, DAO.getCliente().findById(cliente.getClienteID()));
    }

    @Test
    void criaOrdem() {
    }

    @Test
    void finalizaOrdem() {
    }

    @Test
    void cancelaOrdem() {
    }

    @Test
    void addServico() {
    }

    @Test
    void finalizaServico() {
    }

    @Test
    void buscaServicosPorOrdem() {
    }

    @Test
    void removeServico() {
    }

    @Test
    void relacionaOrdemATecnico() {
    }

    @Test
    void gerarFatura() {
    }

    @Test
    void verEstoque() {
    }

    @Test
    void realizaOrdemCompra() {
    }

    @Test
    void geraRelatorio() {
    }

    @Test
    void verAgendaDeAtendimento() {
    }

    @Test
    void main() {
    }
}