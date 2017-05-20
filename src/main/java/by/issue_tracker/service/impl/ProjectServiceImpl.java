package by.issue_tracker.service.impl;

import by.issue_tracker.dao.DaoFactory;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.ProjectDao;
import by.issue_tracker.models.Project;
import by.issue_tracker.service.ProjectService;
import by.issue_tracker.service.exception.ServiceException;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    public List<Project> getAll() throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        ProjectDao projectDao = daoObjectFactory.getProjectDao();
        List<Project> projects;
        try {
            projects = projectDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return projects;
    }

    public Project update(Project entity) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        ProjectDao projectDAO = daoObjectFactory.getProjectDao();
        try {
            projectDAO.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return entity;
    }

    public boolean delete(Integer id) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        ProjectDao projectDAO = daoObjectFactory.getProjectDao();
        try {
            projectDAO.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return true;
    }

    public boolean create(Project entity) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        ProjectDao projectDAO = daoObjectFactory.getProjectDao();
        try {
            projectDAO.create(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return true;
    }
}
