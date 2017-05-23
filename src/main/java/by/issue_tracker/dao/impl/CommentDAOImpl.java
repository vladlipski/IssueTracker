package by.issue_tracker.dao.impl;

import by.issue_tracker.dao.ICommentDAO;
import by.issue_tracker.dao.exception.DAOException;
import by.issue_tracker.dao.mapper.CommentRowMapper;
import by.issue_tracker.model.Comment;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImpl implements ICommentDAO {
    private static final String SELECT_ALL_COMMENTS = "SELECT * FROM comment";
    private static final String UPDATE_COMMENT = "UPDATE comment SET content=?, task_id=?, author_id=? WHERE id=?";
    private static final String GET_COMMENT_BY_ID = "SELECT * FROM comment WHERE id=?";
    private static final String DELETE_COMMENT = "DELETE FROM comment WHERE id=?";
    private static final String CREATE_COMMENT = "INSERT INTO comment VALUES(NULL, ?, ?, ?)";

    private final static Logger logger = Logger.getLogger(CommentDAOImpl.class);

    private final JdbcTemplate jdbcTemplate;
    private final CommentRowMapper commentRowMapper;

    @Autowired
    public CommentDAOImpl(JdbcTemplate jdbcTemplate, CommentRowMapper commentRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.commentRowMapper = commentRowMapper;
    }

    @Override
    public List<Comment> getAll() throws DAOException {
        try {
            return jdbcTemplate.query(SELECT_ALL_COMMENTS, commentRowMapper);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
    }

    @Override
    public boolean update(Comment comment) throws DAOException {
        int id = comment.getId();
        int taskId = comment.getTaskId();
        int authorId = comment.getAuthorId();
        String content = comment.getContent();
        int result;
        try {
            result = jdbcTemplate.update(UPDATE_COMMENT, content, taskId, authorId, id);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }

    @Override
    public Comment getEntityById(Integer id) throws DAOException {
        Comment comment;
        try {
            comment = jdbcTemplate.queryForObject(GET_COMMENT_BY_ID, new Object[]{id}, commentRowMapper);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return comment;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        int result;
        try {
            result = jdbcTemplate.update(DELETE_COMMENT, id);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }

    @Override
    public boolean create(Comment comment) throws DAOException {
        int taskId = comment.getTaskId();
        int authorId = comment.getAuthorId();
        String content = comment.getContent();
        int result;
        try {
            result = jdbcTemplate.update(CREATE_COMMENT, taskId, authorId, content);
        } catch (DataAccessException ex) {
            logger.error(ex);
            throw new DAOException(ex);
        }
        return result != 0;
    }
}
