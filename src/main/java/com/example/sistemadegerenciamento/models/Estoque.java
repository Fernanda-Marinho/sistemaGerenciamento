package com.example.sistemadegerenciamento.models;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe responsável por armazenar informações do almoxorifado: peças e ordens de compra.
 * */

public class Estoque {
    //Atributo estático para armazenar a única instância da classe
    private static Estoque instancia;
    //Construtor privado para impedir que outras classes instanciem a classe diretamente.
    private Estoque(){

    }
    //Método estático que retorna a instância única da classe. Padrão Singleton.
    public static Estoque getInstance() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }
}