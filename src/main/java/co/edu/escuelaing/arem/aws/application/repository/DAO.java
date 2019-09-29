package co.edu.escuelaing.arem.aws.application.repository;

import java.io.Serializable;
import java.util.List;

public interface DAO<T extends Serializable, PK> {

    public List<T> findAll();
    public T find(PK id);
    public PK save(T entity);
    public void upadate(T entity);
    public void delete(T o);
}
