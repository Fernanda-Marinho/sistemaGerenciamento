package com.example.sistemadegerenciamento.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Testes estão dando erro pois fala que não tem peça no estoque
class ServicoTest {

    @Test
    void getCategoria() throws Exception {
        Peca peca = new Peca("Peça1", 10.0);
        Servico servico = new Servico(CategoriaServico.MONTAGEM, 50.0, 1, peca, "Descrição1");
        assertEquals(CategoriaServico.MONTAGEM, servico.getCategoria());
    }

    @Test
    void setCategoria() {

    }

    @Test
    void getValor() {
    }

    @Test
    void setValor() {
    }

    @Test
    void getHorarioAbertura() {
    }

    @Test
    void setHorarioAbertura() {
    }

    @Test
    void getHorarioFinalizacao() {
    }

    @Test
    void setHorarioFinalizacao() {
    }

    @Test
    void getOrdemID() {
    }

    @Test
    void setOrdemID() {
    }

    @Test
    void getPeca() {
    }

    @Test
    void setPeca() {
    }

    @Test
    void getDescricao() {
    }

    @Test
    void setDescricao() {
    }
}