package com.example.sistemadegerenciamento.DAO.tecnico;

import com.example.sistemadegerenciamento.models.Tecnico;

import java.util.HashMap;

/**
 * Classe que implementa todos os métodos de TecnicoDAO;
 * */
public class TecnicoDAOImplementacao implements TecnicoDAO{
    /**
     * HashMap de todos os técnicos criados;
     * */
    HashMap<Integer, Tecnico> tecnicos = new HashMap<Integer, Tecnico>();
    /**
     * Método que registra um técnico no HashMap;
     * */
    @Override
    public Tecnico create(Tecnico tecnico) {
        tecnicos.put(tecnico.getTecnicoID(), tecnico);
        return tecnico;
    }
    /**
     * Método que busca e retorna um técnico no HashMap;
     * */
    @Override
    public Tecnico findById(int tecnicoID) {
        return tecnicos.get(tecnicoID);
    }
    /**
     * Método que retorna todos os técnicos do HashMap;
     * */
    public HashMap<Integer, Tecnico> findMany(){
        return tecnicos;
    }
    /**
     * Método que atualiza um técnico no HashMap;
     * */
    public void update(int tecnicoID, String nome, String senha){
        if (tecnicos.get(tecnicoID) != null) {
            Tecnico tecnico = tecnicos.get(tecnicoID);
            tecnico.setNome(nome);
            tecnico.setSenha(senha);
            tecnicos.put(tecnicoID, tecnico);
        }
    }
    /**
     * Método que deleta um técnico do HashMap;
     * */
    @Override
    public void delete(int tecnicoID) throws Exception {
        if (tecnicos.get(tecnicoID) != null) {
            tecnicos.remove(tecnicoID);
        }
    }
    /**
     * Método que limpa o HashMap;
     * */
    @Override
    public void deleteMany() {
        tecnicos.clear();
    }
}
