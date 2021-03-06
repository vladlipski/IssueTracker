package by.issue_tracker.service.impl;

import by.issue_tracker.dao.DaoFactory;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.UserDao;
import by.issue_tracker.models.User;
import by.issue_tracker.service.interfaces.UserService;
import by.issue_tracker.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements UserService {

    public List<User> getAll() throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        UserDao userDAO = daoObjectFactory.getUserDao();
        List<User> users;
        try {
            users = userDAO.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return users;
    }

    public User update(User entity) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        UserDao userDAO = daoObjectFactory.getUserDao();
        try {
            userDAO.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return entity;
    }

    public boolean delete(Integer id) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        UserDao userDAO = daoObjectFactory.getUserDao();
        try {
            userDAO.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return true;
    }

    public boolean create(User entity) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        UserDao userDAO = daoObjectFactory.getUserDao();
        try {
            userDAO.create(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return true;
    }
}
