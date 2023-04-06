package com.example.sistemadegerenciamento.DAO.ordem;

import com.example.sistemadegerenciamento.models.Ordem;

import java.util.HashMap;

public class OrdemDAOImplementacao implements OrdemDAO{
    HashMap<Integer, Ordem> ordens = new HashMap<Integer, Ordem>();

    @Override
    public Ordem create(Ordem ordem) {
        ordens.put(ordem.getOrdemID(), ordem);
        return null;
    }

    @Override
    public Ordem findById(int ordemID) {
        return ordens.get(ordemID);
    }

    @Override
    public void delete(int ordemID) throws Exception {
        if (ordens.get(ordemID) != null){
            ordens.remove(ordemID);
        }
    }

    @Override
    public void deleteMany() {
        ordens.clear();
    }
}
