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

    @Override
    public void update(Tecnico obj) throws Exception {

    }

    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public void deleteMany() {

    }
}
