package by.issue_tracker.service;

import by.issue_tracker.dao.AbstractMySqlDao;
import by.issue_tracker.dao.UserMySqlDao;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.UserDao;
import by.issue_tracker.models.User;

import java.util.List;

public class AccountService extends AbstractMySqlDao {

    public User signIn(String email, String password) throws DaoException {
        User user = null;
        UserDao userDAO = new UserMySqlDao();
        try {
            user = userDAO.getUser(email, password);
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return user;
    }
}
