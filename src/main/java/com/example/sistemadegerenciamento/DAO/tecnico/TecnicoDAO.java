package com.example.sistemadegerenciamento.DAO.tecnico;

import com.example.sistemadegerenciamento.DAO.CRUD;
import com.example.sistemadegerenciamento.models.Tecnico;

/*
 * Esta interface serve para adicionar funcionalidades que o CRUD não tem, para ser implementado pelo tipo
 * de implementação da persistência.
 * */

public interface TecnicoDAO extends CRUD<Tecnico, Exception> {
}
