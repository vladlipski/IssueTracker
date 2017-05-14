package by.issue_tracker.service;


import by.issue_tracker.models.User;
import by.issue_tracker.service.exception.ServiceException;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers() throws ServiceException;

    public User updateUser(User user) throws ServiceException;

    public boolean deleteUser(Integer id) throws ServiceException;

    public boolean createUser(User user) throws ServiceException;
}
