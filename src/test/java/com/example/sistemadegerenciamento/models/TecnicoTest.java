package com.example.sistemadegerenciamento.models;
import com.example.sistemadegerenciamento.models.CategoriaServico;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TecnicoTest {

    @Test
    void addOrdem(){
        //falta esse
    }
    @Test
    void isAdm() {
        Tecnico tecnico1 = new Tecnico(true, "Técnico1", "1111");
        assertTrue(tecnico1.isAdm());
        Tecnico tecnico2 = new Tecnico(false, "Técnico2", "2222");
        assertFalse(tecnico2.isAdm());
    }

    @Test
    void setAdm() {
        Tecnico tecnico = new Tecnico(true, "Técnico1", "1111");
        assertTrue(tecnico.isAdm());
        tecnico.setAdm(false);
        assertFalse(tecnico.isAdm());
    }

    @Test
    void getNome() {
        Tecnico tecnico = new Tecnico(false, "Técnico1", "1245");
        assertEquals("Técnico1", tecnico.getNome());
        Tecnico tecnico2 = new Tecnico(true, "Técnico2", "1234");
        assertEquals("Técnico2", tecnico2.getNome());
    }

    @Test
    void setNome() {
        Tecnico tecnico = new Tecnico(false, "Técnico1", "1234");
        tecnico.setNome("Técnico2");
        assertEquals("Técnico2", tecnico.getNome());
    }

    @Test
    void getSenha() {
        Tecnico tecnico = new Tecnico(true, "Técnico1", "1234");
        String senhaEsperada = "1234";
        String senhaObtida = tecnico.getSenha();
        assertEquals(senhaEsperada, senhaObtida);
        //se a senha for null
        Tecnico tecnico1 = new Tecnico(true, "Técnico2", null);
        String senhaEsperada1 = null;
        String senhaObtida1 = tecnico1.getSenha();
        assertEquals(senhaEsperada1, senhaObtida1);
    }

    @Test
    void setSenha() {
        Tecnico tecnico = new Tecnico(true, "Técnico1", "1234");
        tecnico.setSenha("123455");
        assertEquals("123455", tecnico.getSenha());
    }

    @Test
    void getTecnicoID() {
        Tecnico tecnico = new Tecnico(true, "Técnico1", "123456");
        int tecnicoID = tecnico.getTecnicoID();
        assertEquals(1, tecnicoID);
    }
}