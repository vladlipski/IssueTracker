package by.issue_tracker.dao.impl;

import by.issue_tracker.dao.IProjectDAO;
import by.issue_tracker.dao.exception.DAOException;
import by.issue_tracker.dao.mapper.ProjectRowMapper;
import by.issue_tracker.model.Project;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAOImpl implements IProjectDAO {
    private static final String SELECT_ALL_PROJECTS = "SELECT * FROM project";
    private static final String UPDATE_PROJECT = "UPDATE project SET name=?, description=?, creation_date=?, manager_id=? WHERE id=?";
    private static final String GET_PROJECT_BY_ID = "SELECT * FROM project WHERE id=?";
    private static final String DELETE_PROJECT = "DELETE FROM project WHERE id=?";
    private static final String CREATE_PROJECT = "INSERT INTO project VALUES (NULL, ?, ?, ?, ?)";

    private final static Logger logger = Logger.getLogger(ProjectDAOImpl.class);

    private final JdbcTemplate jdbcTemplate;
    private final ProjectRowMapper projectRowMapper;

    @Autowired
    public ProjectDAOImpl(JdbcTemplate jdbcTemplate, ProjectRowMapper projectRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.projectRowMapper = projectRowMapper;
    }

    @Override
    public List<Project> getAll() throws DAOException {
        try {
            return jdbcTemplate.query(SELECT_ALL_PROJECTS, projectRowMapper);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
    }

    @Override
    public boolean update(Project project) throws DAOException {
        int id = project.getId();
        String name = project.getName();
        String description = project.getDescription();
        String creationDate = project.getCreationDate().toString();
        int managerId = project.getManagerId();
        int result;
        try {
            result = jdbcTemplate.update(UPDATE_PROJECT, name, description, creationDate, managerId, id);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }

    @Override
    public Project getEntityById(Integer id) throws DAOException {
        Project project;
        try {
            project = jdbcTemplate.queryForObject(GET_PROJECT_BY_ID, new Object[]{id}, projectRowMapper);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return project;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        int result;
        try {
            result = jdbcTemplate.update(DELETE_PROJECT, id);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }

    @Override
    public boolean create(Project project) throws DAOException {
        String name = project.getName();
        String description = project.getDescription();
        String creationDate = project.getCreationDate().toString();
        int managerId = project.getManagerId();
        int result;
        try {
            result = jdbcTemplate.update(CREATE_PROJECT, name, creationDate, description, managerId);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }
}
