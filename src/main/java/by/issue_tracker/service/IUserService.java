package by.issue_tracker.service;


import by.issue_tracker.model.User;
import by.issue_tracker.model.dto.UserSignUpDTO;
import by.issue_tracker.service.exception.ServiceException;

public interface IUserService extends ICrudService<User> {
    User logIn(String email, String password) throws ServiceException;

    boolean checkEmail(String email) throws ServiceException;

    boolean signUp(UserSignUpDTO user) throws ServiceException;

}
