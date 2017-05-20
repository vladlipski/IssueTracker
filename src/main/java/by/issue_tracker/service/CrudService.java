package by.issue_tracker.service;

import by.issue_tracker.service.exception.ServiceException;

import java.util.List;

public interface CrudService<E>  {
    public List<E> getAll() throws ServiceException;

    public E update(E entity) throws ServiceException;

    public boolean delete(Integer id) throws ServiceException;

    public boolean create(E entity) throws ServiceException;
}
