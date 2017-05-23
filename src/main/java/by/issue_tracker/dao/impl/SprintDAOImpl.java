package by.issue_tracker.dao.impl;

import by.issue_tracker.dao.ISprintDAO;
import by.issue_tracker.dao.exception.DAOException;
import by.issue_tracker.dao.mapper.SprintRowMapper;
import by.issue_tracker.model.Sprint;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SprintDAOImpl implements ISprintDAO {
    private static final String SELECT_ALL_SPRINTS = "SELECT * FROM sprint";
    private static final String UPDATE_SPRINT = "UPDATE sprint SET name=?, start_date=?, end_date=?, project_id=? WHERE id=?";
    private static final String GET_SPRINT_BY_ID = "SELECT * FROM sprint WHERE id=?";
    private static final String DELETE_SPRINT = "DELETE FROM sprint WHERE id=?";
    private static final String CREATE_SPRINT = "INSERT INTO sprint VALUES (NULL, ?, ?, ?, ?)";

    private final static Logger logger = Logger.getLogger(SprintDAOImpl.class);

    private final JdbcTemplate jdbcTemplate;
    private final SprintRowMapper sprintRowMapper;

    @Autowired
    public SprintDAOImpl(JdbcTemplate jdbcTemplate, SprintRowMapper sprintRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.sprintRowMapper = sprintRowMapper;
    }

    @Override
    public List<Sprint> getAll() throws DAOException {
        try {
            return jdbcTemplate.query(SELECT_ALL_SPRINTS, sprintRowMapper);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
    }

    @Override
    public boolean update(Sprint sprint) throws DAOException {
        int id = sprint.getId();
        String name = sprint.getName();
        String startDate = sprint.getStartDate().toString();
        String endDate = sprint.getEndDate().toString();
        int projectId = sprint.getProjectId();
        int result;
        try {
            result = jdbcTemplate.update(UPDATE_SPRINT, name, startDate, endDate, projectId, id);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }

    @Override
    public Sprint getEntityById(Integer id) throws DAOException {
        Sprint sprint;
        try {
            sprint = jdbcTemplate.queryForObject(GET_SPRINT_BY_ID, new Object[]{id}, sprintRowMapper);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return sprint;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        int result;
        try {
            result = jdbcTemplate.update(DELETE_SPRINT, id);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }

    @Override
    public boolean create(Sprint sprint) throws DAOException {
        String name = sprint.getName();
        String startDate = sprint.getStartDate().toString();
        String endDate = sprint.getEndDate().toString();
        int projectId = sprint.getProjectId();
        int result;
        try {
            result = jdbcTemplate.update(CREATE_SPRINT, name, startDate, endDate, projectId);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }
}
