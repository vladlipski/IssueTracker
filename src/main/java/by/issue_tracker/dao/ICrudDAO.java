package by.issue_tracker.dao;

import by.issue_tracker.dao.exception.DAOException;

import java.util.List;

public interface ICrudDAO<E, K> {
    List<E> getAll() throws DAOException;

    boolean update(E entity) throws DAOException;

    E getEntityById(K id) throws DAOException;

    boolean delete(K id) throws DAOException;

    boolean create(E entity) throws DAOException;
}
