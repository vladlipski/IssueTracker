package by.issue_tracker.service.impl;

import by.issue_tracker.dao.ISprintDAO;
import by.issue_tracker.dao.exception.DAOException;
import by.issue_tracker.model.Sprint;
import by.issue_tracker.service.ISprintService;
import by.issue_tracker.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintServiceImpl implements ISprintService {

    private final ISprintDAO sprintDAO;

    @Autowired
    public SprintServiceImpl(ISprintDAO sprintDAO) {
        this.sprintDAO = sprintDAO;
    }

    @Override
    public List<Sprint> getAll() throws ServiceException {

        List<Sprint> sprints;
        try {
            sprints = sprintDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return sprints;
    }

    @Override
    public boolean update(Sprint sprint) throws ServiceException {

        try {
            return sprintDAO.update(sprint);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(Integer id) throws ServiceException {

        try {
            return sprintDAO.delete(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(Sprint sprint) throws ServiceException {

        try {
            return sprintDAO.create(sprint);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
