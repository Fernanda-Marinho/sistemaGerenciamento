package com.example.sistemadegerenciamento.controller;

import com.example.sistemadegerenciamento.DAO.DAO;
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
    }

    @Test
    void buscaTecnico() {
    }

    @Test
    void validaLogin() {
    }

    @Test
    void criaCliente() {
    }

    @Test
    void atualizaCliente() {
    }

    @Test
    void deletaCliente() {
    }

    @Test
    void buscaTodosClientes() {
    }

    @Test
    void buscaCliente() {
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