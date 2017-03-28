package by.issue_tracker.dao;

import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.UserEntity;
import by.issue_tracker.models.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao extends Dao implements UserEntity {
    private static final String SELECT_ALL_USERS = "SELECT * FROM USER";

    public List<User> getAll() throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        List<User> users = null;
        try {
            users = (List<User>)queryRunner.query(connection, SELECT_ALL_USERS, new BeanListHandler(User.class));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return users;
    }

    public User update(User entity) throws DaoException {
        return null;
    }

    public User getEntityById(Integer id) throws DaoException {
        return null;
    }

    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    public boolean create(User entity) throws DaoException {
        return false;
    }
}
