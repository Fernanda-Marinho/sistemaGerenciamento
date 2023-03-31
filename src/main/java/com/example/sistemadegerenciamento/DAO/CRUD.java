package com.example.sistemadegerenciamento.DAO;
import java.util.List;

public interface CRUD<T, E extends Exception> {
    public T create(T obj);
    public T findById(int id);
    public List<T> findMany();
    public void update(T obj) throws E;
    public void delete(int id) throws E;
    public void deleteMany();

}
