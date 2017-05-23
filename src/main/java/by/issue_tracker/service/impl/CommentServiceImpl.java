package by.issue_tracker.service.impl;

import by.issue_tracker.dao.ICommentDAO;
import by.issue_tracker.dao.exception.DAOException;
import by.issue_tracker.model.Comment;
import by.issue_tracker.service.ICommentService;
import by.issue_tracker.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    private final ICommentDAO commentDAO;

    @Autowired
    public CommentServiceImpl(ICommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    public List<Comment> getAll() throws ServiceException {
        List<Comment> comments;
        try {
            comments = commentDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return comments;
    }

    @Override
    public boolean update(Comment comment) throws ServiceException {
        try {
            return commentDAO.update(comment);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(Integer id) throws ServiceException {
        try {
            return commentDAO.delete(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean create(Comment comment) throws ServiceException {
        try {
            return commentDAO.create(comment);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
