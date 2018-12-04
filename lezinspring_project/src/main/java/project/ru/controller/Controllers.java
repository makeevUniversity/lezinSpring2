package project.ru.controller;

import java.util.List;
import java.util.UUID;


public interface Controllers<T> {

    List<T> findAll();

    T findById(String uuid);

    void update(T entity);

    void insert(T entity);

    void delete(T entity);

}
