package com.example.sistemadegerenciamento.models;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ServicoTest {

    @Test
    void getCategoria() throws Exception {
        try {
            Peca peca = new Peca("Peça1", 10.0);
            Servico servico = new Servico(CategoriaServico.MONTAGEM, 50.0, 1, peca, "Descrição1");
        } catch (Exception e) {
            if (e instanceof Exception) {
                System.out.println("A exceção é do tipo java.lang.Exception");
            }
        }
        Servico servico2 = new Servico(CategoriaServico.LIMPEZA, 50.0, 1, null, "Descrição2");
        assertEquals(servico2.getCategoria(), CategoriaServico.LIMPEZA);
    }

    @Test
    void getValor() throws Exception {
        double valor = 321.98;
        Servico servico2 = new Servico(CategoriaServico.LIMPEZA, valor, 1, null, "Descrição2");
        assertEquals(servico2.getValor(), valor);
    }

    @Test
    void setValor() throws Exception {
        double valor = 321.98;
        Servico servico2 = new Servico(CategoriaServico.LIMPEZA, valor, 1, null, "Descrição2");
        servico2.setValor(valor+10);
        assertEquals(servico2.getValor(), valor+10);
    }

    @Test
    void getOrdemID() throws Exception {
        double valor = 321.98;
        Servico servico2 = new Servico(CategoriaServico.LIMPEZA, valor, 1, null, "Descrição2");
        assertEquals(servico2.getOrdemID(), 1);
    }

    @Test
    void setOrdemID() throws Exception {
        double valor = 321.98;
        Servico servico2 = new Servico(CategoriaServico.LIMPEZA, valor, 1, null, "Descrição2");
        assertEquals(servico2.getOrdemID(), 1);
        servico2.setOrdemID(2);
        assertEquals(servico2.getOrdemID(), 2);
    }
}