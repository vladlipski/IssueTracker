package by.issue_tracker.dao.impl;

import by.issue_tracker.dao.AbstractMySqlDao;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.SprintDao;
import by.issue_tracker.models.Sprint;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class SprintMySqlDao extends AbstractMySqlDao implements SprintDao{
    private static final String SELECT_ALL_SPRINTS = "SELECT * FROM sprint";
    private static final String UPDATE_SPRINT = "UPDATE sprint SET";
    private static final String DELETE_SPRINT = "DELETE FROM sprint WHERE id='";
    private static final String CREATE_SPRINT = "INSERT INTO sprint VALUES";

    public List<Sprint> getAll() throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        List<Sprint> sprints;
        try {
            sprints = (List<Sprint>)queryRunner.query(connection, SELECT_ALL_SPRINTS, new BeanListHandler(Sprint.class));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return sprints;
    }

    public Sprint update(Sprint entity) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        Integer code;
        try {
            code = queryRunner.update(connection, UPDATE_SPRINT + " name='" + entity.getName()
                    + "', start_date='" + entity.getStart_date() + "', end_date='" + entity.getEnd_date() +
                    "', project_id='" + entity.getProject_id() + "' WHERE id='" +
                    entity.getId() + "'");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return entity;
    }

    public Sprint getEntityById(Integer id) throws DaoException {
        return null;
    }

    public boolean delete(Integer id) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        Integer code;
        try {
            code = queryRunner.update(connection, DELETE_SPRINT + id.toString() + "'");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    public boolean create(Sprint entity) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        Integer code;
        try {
            code = queryRunner.update(connection, CREATE_SPRINT + "(" + "null, '" + entity.getName() +"', '" +
                    entity.getStart_date() + "', '" + entity.getEnd_date()+ "', '" +
                    entity.getProject_id() + "');");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }
}
