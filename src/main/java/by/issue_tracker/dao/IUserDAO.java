package by.issue_tracker.dao;

import by.issue_tracker.dao.exception.DAOException;
import by.issue_tracker.model.User;
import by.issue_tracker.model.dto.UserSignUpDTO;

public interface IUserDAO extends ICrudDAO<User, Integer> {
    User logIn(String email, String password) throws DAOException;

    boolean checkEmail(String email) throws DAOException;

    boolean signUp(UserSignUpDTO user) throws DAOException;
}
