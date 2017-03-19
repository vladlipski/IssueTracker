package by.issue_tracker.dao;

import by.issue_tracker.models.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao extends Dao<User, Integer> {
    private static final String SELECT_ALL_USERS = "SELECT * FROM USER";

    public List<User> getAll() {
        QueryRunner query = new QueryRunner();
        List<User> users = null;
        try {
            users = (List<User>)query.query(connection, SELECT_ALL_USERS, new BeanListHandler(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User update(User entity) {
        return null;
    }

    public User getEntityById(Integer id) {
        return null;
    }

    public boolean delete(Integer id) {
        return false;
    }

    public boolean create(User entity) {
        return false;
    }
}
