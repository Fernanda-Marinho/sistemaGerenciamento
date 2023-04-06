package com.example.sistemadegerenciamento.DAO.tecnico;

import com.example.sistemadegerenciamento.models.Tecnico;

import java.util.HashMap;


public class TecnicoDAOImplementacao implements TecnicoDAO{

    HashMap<Integer, Tecnico> tecnicos = new HashMap<Integer, Tecnico>();

    @Override
    public Tecnico create(Tecnico tecnico) {
        tecnicos.put(tecnico.getTecnicoID(), tecnico);
        return tecnico;
    }

    @Override
    public Tecnico findById(int tecnicoID) {
        return tecnicos.get(tecnicoID);
    }

    public void update(int tecnicoID, String nome, String senha){
        if (tecnicos.get(tecnicoID) != null) {
            Tecnico tecnico = tecnicos.get(tecnicoID);
            tecnico.setNome(nome);
            tecnico.setSenha(senha);
            tecnicos.put(tecnicoID, tecnico);
        }
    }
    @Override
    public void delete(int tecnicoID) throws Exception {
        if (tecnicos.get(tecnicoID) != null) {
            tecnicos.remove(tecnicoID);
        }
    }
    @Override
    public void deleteMany() {
        tecnicos.clear();
    }
}
