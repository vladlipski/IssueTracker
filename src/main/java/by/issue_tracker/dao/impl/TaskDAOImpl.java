package by.issue_tracker.dao.impl;

import by.issue_tracker.dao.ITaskDAO;
import by.issue_tracker.dao.exception.DAOException;
import by.issue_tracker.dao.mapper.TaskRowMapper;
import by.issue_tracker.model.Task;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOImpl implements ITaskDAO {
    private static final String SELECT_ALL_TASKS = "SELECT * FROM task";
    private static final String UPDATE_TASK = "UPDATE task SET name=?, description=?, due_date=?, done=?, sprint_id=?, performer_id=? WHERE id=?";
    private static final String GET_TASK_BY_ID = "SELECT * FROM task WHERE id=?";
    private static final String DELETE_TASK = "DELETE FROM task WHERE id=?";
    private static final String CREATE_TASK = "INSERT INTO task VALUES (null, ?, ?, ?, ?, ?, ?)";
    private final JdbcTemplate jdbcTemplate;
    private final TaskRowMapper taskRowMapper;

    private final static Logger logger = Logger.getLogger(TaskDAOImpl.class);

    @Autowired
    public TaskDAOImpl(JdbcTemplate jdbcTemplate, TaskRowMapper taskRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.taskRowMapper = taskRowMapper;
    }

    public List<Task> getAll() throws DAOException {
        try {
            return jdbcTemplate.query(SELECT_ALL_TASKS, taskRowMapper);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
    }

    @Override
    public boolean update(Task task) throws DAOException {
        int id = task.getId();
        String name = task.getName();
        String description = task.getDescription();
        String dueDate = task.getDueDate().toString();
        String done = task.getDone();
        int sprintId = task.getSprintId();
        int performerId = task.getPerformerId();
        int result;
        try {
            result = jdbcTemplate.update(UPDATE_TASK, name, description, dueDate, done, sprintId, performerId, id);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }

    @Override
    public Task getEntityById(Integer id) throws DAOException {
        Task task;
        try {
            task = jdbcTemplate.queryForObject(GET_TASK_BY_ID, new Object[]{id}, taskRowMapper);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return task;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        int result;
        try {
            result = jdbcTemplate.update(DELETE_TASK, id);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }

    @Override
    public boolean create(Task task) throws DAOException {
        String name = task.getName();
        String description = task.getDescription();
        String dueDate = task.getDueDate().toString();
        String done = task.getDone();
        int sprintId = task.getSprintId();
        int performerId = task.getPerformerId();
        int result;
        try {
            result = jdbcTemplate.update(CREATE_TASK, name, description, dueDate, done, sprintId, performerId);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }
}
