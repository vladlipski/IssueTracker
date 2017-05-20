package by.issue_tracker.service.impl;

import by.issue_tracker.dao.DaoFactory;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.CommentDao;
import by.issue_tracker.models.Comment;
import by.issue_tracker.service.exception.ServiceException;
import by.issue_tracker.service.interfaces.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService{

    public List<Comment> getAll() throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        CommentDao commentDAO = daoObjectFactory.getCommentDao();
        List<Comment> comments;
        try {
            comments = commentDAO.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return comments;
    }

    public Comment update(Comment entity) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        CommentDao commentDAO = daoObjectFactory.getCommentDao();
        try {
            commentDAO.update(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return entity;
    }

    public boolean delete(Integer id) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        CommentDao commentDAO = daoObjectFactory.getCommentDao();
        try {
            commentDAO.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return true;
    }

    public boolean create(Comment entity) throws ServiceException {
        DaoFactory daoObjectFactory = DaoFactory.getInstance();
        CommentDao commentDAO = daoObjectFactory.getCommentDao();
        try {
            commentDAO.create(entity);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return true;
    }
}
