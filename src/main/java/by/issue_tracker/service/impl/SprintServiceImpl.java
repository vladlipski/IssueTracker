package by.issue_tracker.service.impl;

import by.issue_tracker.dao.DaoFactory;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.SprintDao;
import by.issue_tracker.models.Sprint;
import by.issue_tracker.service.exception.ServiceException;
import by.issue_tracker.service.interfaces.SprintService;

import java.util.List;

public class SprintServiceImpl implements SprintService{

    public List<Sprint> getAll() throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        SprintDao sprintDAO = daoObjectFactory.getSprintDao();
        List<Sprint> sprints;
        try {
            sprints = sprintDAO.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return sprints;
    }

    public Sprint update(Sprint entity) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        SprintDao sprintDAO = daoObjectFactory.getSprintDao();
        try {
            sprintDAO.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return entity;
    }

    public boolean delete(Integer id) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        SprintDao sprintDAO = daoObjectFactory.getSprintDao();
        try {
            sprintDAO.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return true;
    }

    public boolean create(Sprint entity) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        SprintDao sprintDAO = daoObjectFactory.getSprintDao();
        try {
            sprintDAO.create(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return true;
    }
}
