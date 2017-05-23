package by.issue_tracker.service;

import by.issue_tracker.service.exception.ServiceException;

import java.util.List;

public interface ICrudService<E> {
    List<E> getAll() throws ServiceException;

    boolean update(E entity) throws ServiceException;

    boolean delete(Integer id) throws ServiceException;

    boolean create(E entity) throws ServiceException;
}
