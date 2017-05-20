package by.issue_tracker.dao.impl;

import by.issue_tracker.dao.AbstractMySqlDao;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.CommentDao;
import by.issue_tracker.models.Comment;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CommentMySqlDao extends AbstractMySqlDao implements CommentDao{
    private static final String SELECT_ALL_COMMENTS = "SELECT * FROM comment";
    private static final String UPDATE_COMMENT = "UPDATE comment SET";
    private static final String DELETE_COMMENT = "DELETE FROM comment WHERE id='";
    private static final String CREATE_COMMENT = "INSERT INTO comment VALUES";

    public List<Comment> getAll() throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        List<Comment> comments;
        try {
            comments = (List<Comment>)queryRunner.query(connection, SELECT_ALL_COMMENTS, new BeanListHandler(Comment.class));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return comments;
    }

    public Comment update(Comment entity) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        Integer code;
        try {
            code = queryRunner.update(connection, UPDATE_COMMENT + " content='" + entity.getContent()
                    + "', task_id='" + entity.getTask_id() + "', author_id='" + entity.getAuthor_id()
                    + "' WHERE id='" + entity.getId() + "'");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return entity;
    }

    public Comment getEntityById(Integer id) throws DaoException {
        return null;
    }

    public boolean delete(Integer id) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        Integer code;
        try {
            code = queryRunner.update(connection, DELETE_COMMENT + id.toString() + "'");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }

    public boolean create(Comment entity) throws DaoException {
        QueryRunner queryRunner = new QueryRunner();
        Integer code;
        try {
            code = queryRunner.update(connection, CREATE_COMMENT + "(" + "null, '" + entity.getContent() +"', '" +
                    entity.getTask_id() + "', '" + entity.getAuthor_id() + "');");
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return true;
    }
}
