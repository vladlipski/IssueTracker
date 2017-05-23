package by.issue_tracker.service.impl;


import by.issue_tracker.dao.IUserDAO;
import by.issue_tracker.dao.exception.DAOException;
import by.issue_tracker.model.User;
import by.issue_tracker.model.dto.UserSignUpDTO;
import by.issue_tracker.service.IUserService;
import by.issue_tracker.service.exception.ServiceException;
import by.issue_tracker.util.Md5Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserDAO userDAO;
    private final Md5Generator md5Generator;

    @Autowired
    public UserServiceImpl(IUserDAO userDAO, Md5Generator md5Generator) {
        this.userDAO = userDAO;
        this.md5Generator = md5Generator;
    }

    @Override
    public List<User> getAll() throws ServiceException {
        List<User> users;
        try {
            users = userDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return users;
    }

    @Override
    public boolean update(User user) throws ServiceException {
        String hashedPassword = md5Generator.generate(user.getPassword());
        user.setPassword(hashedPassword);
        try {
            return userDAO.update(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(Integer id) throws ServiceException {
        try {
            return userDAO.delete(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(User user) throws ServiceException {
        String hashedPassword = md5Generator.generate(user.getPassword());
        user.setPassword(hashedPassword);
        try {
            return userDAO.create(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User logIn(String email, String password) throws ServiceException {
        User user;
        String hashedPassword = md5Generator.generate(password);
        try {
            user = userDAO.logIn(email, hashedPassword);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public boolean checkEmail(String email) throws ServiceException {
        try {
            return userDAO.checkEmail(email);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean signUp(UserSignUpDTO user) throws ServiceException {
        if (!checkEmail(user.getEmail())) {
            String hashedPassword = md5Generator.generate(user.getPassword());
            user.setPassword(hashedPassword);
            try {
                return userDAO.signUp(user);
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }
        return false;
    }

}
