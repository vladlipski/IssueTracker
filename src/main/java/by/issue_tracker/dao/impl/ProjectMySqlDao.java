package by.issue_tracker.dao.impl;

import by.issue_tracker.dao.AbstractMySqlDao;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.ProjectDao;
import by.issue_tracker.models.Project;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProjectMySqlDao extends AbstractMySqlDao implements ProjectDao {
    private static final String SELECT_ALL_PROJECTS = "SELECT * FROM project";
    private static final String UPDATE_PROJECT = "UPDATE project SET";
    private static final String DELETE_PROJECT = "DELETE FROM project WHERE id='";
    private static final String CREATE_PROJECT = "INSERT INTO project VALUES";
    private static final String SELECT_PROJECT_BY_EMAIL = "SELECT * FROM project WHERE email='";
    
    public List<Project> getAll() throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        List<Project> projects;
        try {
            projects = (List<Project>)queryRunner.query(connection, SELECT_ALL_PROJECTS, new BeanListHandler(Project.class));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return projects;
    }

    public Project update(Project entity) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        Integer code;
        try {
            code = queryRunner.update(connection, UPDATE_PROJECT + " name='" + entity.getName()
                    + "', description='" + entity.getDescription() + "', creation_date='" + entity.getCreation_date() +
                    "', manager_id='" + entity.getManager_id() + "' WHERE id='" +
                    entity.getId() + "'");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return entity;
    }

    public Project getEntityById(Integer id) throws DaoException {
        return null;
    }

    public boolean delete(Integer id) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        Integer code;
        try {
            code = queryRunner.update(connection, DELETE_PROJECT + id.toString() + "'");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    public boolean create(Project entity) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        Integer code;
        try {
            code = queryRunner.update(connection, CREATE_PROJECT + "(" + "null, '" + entity.getName() +"', '" +
                    entity.getCreation_date() + "', '" + entity.getDescription()+ "', '" +
                    entity.getManager_id() + "');");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }
}
