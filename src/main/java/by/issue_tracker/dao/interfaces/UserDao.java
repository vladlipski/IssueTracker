package by.issue_tracker.dao.interfaces;

import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.models.User;

public interface UserDao extends StandardDao<User, Integer> {
    public User getUser(String email, String password) throws DaoException;
}
