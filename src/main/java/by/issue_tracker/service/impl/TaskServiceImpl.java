package by.issue_tracker.service.impl;


import by.issue_tracker.dao.ITaskDAO;
import by.issue_tracker.dao.exception.DAOException;
import by.issue_tracker.model.Task;
import by.issue_tracker.service.ITaskService;
import by.issue_tracker.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {

    private final ITaskDAO taskDAO;

    @Autowired
    public TaskServiceImpl(ITaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public List<Task> getAll() throws ServiceException {
        List<Task> tasks;
        try {
            tasks = taskDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return tasks;
    }

    @Override
    public boolean update(Task task) throws ServiceException {
        try {
            return taskDAO.update(task);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(Integer id) throws ServiceException {
        try {
            return taskDAO.delete(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(Task task) throws ServiceException {
        try {
            return taskDAO.create(task);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
