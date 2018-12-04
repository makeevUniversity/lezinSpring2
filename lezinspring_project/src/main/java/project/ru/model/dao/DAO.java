package project.ru.model.dao;


import java.util.List;
import java.util.UUID;

public interface DAO<T> {

    List<T> findAll();

    T findById(UUID id);

    boolean update(T entity);

    boolean insert(T entity);

    boolean delete(UUID id);
}
