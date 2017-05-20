package by.issue_tracker.service.impl;

import by.issue_tracker.dao.DaoFactory;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.TaskDao;
import by.issue_tracker.models.Task;
import by.issue_tracker.service.exception.ServiceException;
import by.issue_tracker.service.interfaces.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService{
    public List<Task> getAll() throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        TaskDao taskDAO = daoObjectFactory.getTaskDao();
        List<Task> tasks;
        try {
            tasks = taskDAO.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return tasks;
    }

    public Task update(Task entity) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        TaskDao taskDAO = daoObjectFactory.getTaskDao();
        try {
            taskDAO.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return entity;
    }

    public boolean delete(Integer id) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        TaskDao taskDAO = daoObjectFactory.getTaskDao();
        try {
            taskDAO.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return true;
    }

    public boolean create(Task entity) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        TaskDao taskDAO = daoObjectFactory.getTaskDao();
        try {
            taskDAO.create(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return true;
    }
}
