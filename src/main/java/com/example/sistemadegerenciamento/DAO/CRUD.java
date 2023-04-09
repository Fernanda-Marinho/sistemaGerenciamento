package com.example.sistemadegerenciamento.DAO;
import java.util.List;


/**
 * Interface de CRUD, responsável por agrupar as principais funcionalidades do CRUD.
 * */
public interface CRUD<T, E extends Exception> {
    public T create(T obj);
    public T findById(int id);
    public void delete(int id) throws E;
    public void deleteMany();

}
