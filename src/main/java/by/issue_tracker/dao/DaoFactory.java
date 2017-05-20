package by.issue_tracker.dao;

import by.issue_tracker.dao.impl.ProjectMySqlDao;
import by.issue_tracker.dao.impl.UserMySqlDao;
import by.issue_tracker.dao.interfaces.ProjectDao;
import by.issue_tracker.dao.interfaces.UserDao;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final UserDao userDao = new UserMySqlDao();
    private final ProjectDao projectDao = new ProjectMySqlDao();
    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return instance;
    }

    public UserDao getUserDao(){
        return userDao;
    }

    public ProjectDao getProjectDao(){
        return projectDao;
    }
}

