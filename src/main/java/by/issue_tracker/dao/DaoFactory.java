package by.issue_tracker.dao;

import by.issue_tracker.dao.interfaces.UserDao;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final UserDao userDao = new UserMySqlDao();
    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return instance;
    }
    public UserDao getUserDao(){
        return userDao;
    }
}

