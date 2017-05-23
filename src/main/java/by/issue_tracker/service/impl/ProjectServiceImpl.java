package by.issue_tracker.service.impl;

import by.issue_tracker.dao.IProjectDAO;
import by.issue_tracker.dao.exception.DAOException;
import by.issue_tracker.model.Project;
import by.issue_tracker.service.IProjectService;
import by.issue_tracker.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final IProjectDAO projectDAO;

    @Autowired
    public ProjectServiceImpl(IProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public List<Project> getAll() throws ServiceException {
        List<Project> projects;
        try {
            projects = projectDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return projects;
    }

    @Override
    public boolean update(Project project) throws ServiceException {
        try {
            return projectDAO.update(project);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(Integer id) throws ServiceException {
        try {
            return projectDAO.delete(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(Project project) throws ServiceException {
        try {
            return projectDAO.create(project);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
