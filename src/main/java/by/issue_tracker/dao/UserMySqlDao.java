package by.issue_tracker.dao;

import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.UserDao;
import by.issue_tracker.models.User;
import by.issue_tracker.util.Md5Generator;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserMySqlDao extends AbstractMySqlDao implements UserDao {
    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM user WHERE email='";

    public List<User> getAll() throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        List<User> users;
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

    public User getUser(String email, String password) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        User user;
        try {
            user = (User)queryRunner.query(connection, SELECT_USER_BY_EMAIL.concat(email+"'"),
                    new BeanHandler(User.class));
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        Md5Generator md5Generator = new Md5Generator();
        String passwordMD5 = md5Generator.generate(password);
        String userPasswordMD5 = user.getPassword();
        if (userPasswordMD5.equals(passwordMD5)) {
            return user;
        } else {
            return null;
        }
    }
}
