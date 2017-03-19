package by.issue_tracker.dao;

public class DaoFactory {

    public UserDao getUserDao() {
        return new UserDao();
    }
}
