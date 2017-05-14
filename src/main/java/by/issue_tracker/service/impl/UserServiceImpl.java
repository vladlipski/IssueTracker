package by.issue_tracker.service.impl;

import by.issue_tracker.dao.DaoFactory;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.UserDao;
import by.issue_tracker.models.User;
import by.issue_tracker.service.UserService;
import by.issue_tracker.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements UserService {

    public List<User> getAllUsers() throws ServiceException {
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

    public User updateUser(User user) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        UserDao userDAO = daoObjectFactory.getUserDao();
        try {
            userDAO.update(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    public boolean deleteUser(Integer id) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        UserDao userDAO = daoObjectFactory.getUserDao();
        try {
            userDAO.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return true;
    }


}
