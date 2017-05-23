package by.issue_tracker.dao.impl;

import by.issue_tracker.dao.IUserDAO;
import by.issue_tracker.dao.exception.DAOException;
import by.issue_tracker.dao.mapper.UserRowMapper;
import by.issue_tracker.model.User;
import by.issue_tracker.model.dto.UserSignUpDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements IUserDAO {
    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String UPDATE_USER = "UPDATE user SET first_name=?, last_name=?, email=?, password=?, role_id=? WHERE id=?";
    private static final String DELETE_USER = "DELETE FROM user WHERE id=?";
    private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String CREATE_USER = "INSERT INTO user VALUES (NULL, ?, ?, ?, ?, ?)";
    private static final String LOG_IN = "SELECT * FROM user WHERE email=? AND password=?";
    private static final String CHECK_EMAIL = "SELECT count(*) FROM user WHERE email = ?";
    private static final String SIGN_UP = "INSERT INTO user VALUES (NULL, ?, ?, ?, ?, DEFAULT)";

    private final static Logger logger = Logger.getLogger(UserDAOImpl.class);

    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
    }

    @Override
    public List<User> getAll() throws DAOException {
        try {
            return jdbcTemplate.query(SELECT_ALL_USERS, userRowMapper);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
    }

    @Override
    public boolean update(User user) throws DAOException {
        int id = user.getId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String password = user.getPassword();
        int roleId = user.getRoleId();
        int result;
        try {
            result = jdbcTemplate.update(UPDATE_USER, firstName, lastName, email, password, roleId, id);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }

    @Override
    public User getEntityById(Integer id) throws DAOException {
        User user;
        try {
            user = jdbcTemplate.queryForObject(GET_USER_BY_ID, new Object[]{id}, userRowMapper);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return user;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        int result;
        try {
            result = jdbcTemplate.update(DELETE_USER, id);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }

    @Override
    public boolean create(User user) throws DAOException {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String password = user.getPassword();
        int roleId = user.getRoleId();
        int result;
        try {
            result = jdbcTemplate.update(CREATE_USER, email, password, firstName, lastName, roleId);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }

    @Override
    public User logIn(String email, String password) throws DAOException {
        User user;
        try {
            user = jdbcTemplate.queryForObject(LOG_IN, new Object[]{email, password}, userRowMapper);
        } catch (EmptyResultDataAccessException ex) {
            logger.info("Wrong login or password");
            return null;
        }
        return user;
    }

    @Override
    public boolean checkEmail(String email) throws DAOException {
        int count = jdbcTemplate.queryForObject(CHECK_EMAIL, new Object[]{email}, Integer.class);
        return count != 0;
    }

    @Override
    public boolean signUp(UserSignUpDTO user) throws DAOException {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String password = user.getPassword();
        int result;
        try {
            result = jdbcTemplate.update(SIGN_UP, email, password, firstName, lastName);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }
}
