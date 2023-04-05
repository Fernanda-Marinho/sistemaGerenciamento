package com.example.sistemadegerenciamento.DAO.ordem;

import com.example.sistemadegerenciamento.DAO.CRUD;
import com.example.sistemadegerenciamento.models.Ordem;

/*
 * Esta interface serve para adicionar funcionalidades que o CRUD não tem, para ser implementado pelo tipo
 * de implementação da persistência.
 * */

public interface OrdemDAO extends CRUD<Ordem, Exception> {
}
