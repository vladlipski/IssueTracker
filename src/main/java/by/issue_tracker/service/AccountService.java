package by.issue_tracker.service;

import by.issue_tracker.dao.AbstractMySqlDao;
import by.issue_tracker.dao.DaoFactory;
import by.issue_tracker.dao.interfaces.UserDao;
import by.issue_tracker.models.User;
import by.issue_tracker.service.exception.ServiceException;

public class AccountService extends AbstractMySqlDao {

    public User signIn(String email, String password) throws ServiceException {
        User user;
        DaoFactory factory = DaoFactory.getInstance();
        UserDao userDAO = factory.getUserDao();
        try {
            user = userDAO.getUser(email, password);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return user;
    }
}
