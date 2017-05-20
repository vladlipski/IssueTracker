package by.issue_tracker.dao.impl;

import by.issue_tracker.dao.AbstractMySqlDao;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.TaskDao;
import by.issue_tracker.models.Task;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class TaskMySqlDao extends AbstractMySqlDao implements TaskDao {
    private static final String SELECT_ALL_TASKS = "SELECT * FROM task";
    private static final String UPDATE_TASK = "UPDATE task SET";
    private static final String DELETE_TASK = "DELETE FROM task WHERE id='";
    private static final String CREATE_TASK = "INSERT INTO task VALUES";

    public List<Task> getAll() throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        List<Task> tasks;
        try {
            tasks = (List<Task>)queryRunner.query(connection, SELECT_ALL_TASKS, new BeanListHandler(Task.class));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return tasks;
    }

    public Task update(Task entity) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        Integer code;
        try {
            code = queryRunner.update(connection, UPDATE_TASK + " name='" + entity.getName()
                    + "', description='" + entity.getDescription() + "', due_date='" + entity.getDue_date() +
                    "', done='" + entity.getDone() + "', sprint_id='" + entity.getSprint_id() + "', performer_id='"
                    + entity.getPerformer_id() + "' WHERE id='" +
                    entity.getId() + "'");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return entity;
    }

    public Task getEntityById(Integer id) throws DaoException {
        return null;
    }

    public boolean delete(Integer id) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        Integer code;
        try {
            code = queryRunner.update(connection, DELETE_TASK + id.toString() + "'");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    public boolean create(Task entity) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        Integer code;
        try {
            code = queryRunner.update(connection, CREATE_TASK + "(" + "null, '" + entity.getName() +"', '" +
                    entity.getDescription() + "', '" + entity.getDue_date() + "', '" + entity.getDone()+ "', '" +
                    entity.getSprint_id() + "', '" + entity.getPerformer_id() + "');");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }
}
