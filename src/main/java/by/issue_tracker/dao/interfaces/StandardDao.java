package by.issue_tracker.dao.interfaces;

import by.issue_tracker.dao.exception.DaoException;

import java.util.List;

public interface StandardDao<E, K> {
    List<E> getAll() throws DaoException;
    E update(E entity) throws DaoException;
    E getEntityById(K id) throws DaoException;
    boolean delete(K id) throws DaoException;
    boolean create(E entity) throws DaoException;
}
