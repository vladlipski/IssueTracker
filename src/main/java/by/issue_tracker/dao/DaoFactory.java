package by.issue_tracker.dao;

import by.issue_tracker.dao.impl.*;
import by.issue_tracker.dao.interfaces.*;

public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final UserDao userDao = new UserMySqlDao();
    private final ProjectDao projectDao = new ProjectMySqlDao();
    private final SprintDao sprintDao = new SprintMySqlDao();
    private final TaskDao taskDao = new TaskMySqlDao();
    private final CommentDao commentDao = new CommentMySqlDao();
    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return instance;
    }

    public UserDao getUserDao(){
        return userDao;
    }

    public ProjectDao getProjectDao(){
        return projectDao;
    }

    public SprintDao getSprintDao(){
        return sprintDao;
    }

    public TaskDao getTaskDao(){
        return taskDao;
    }

    public CommentDao getCommentDao(){
        return commentDao;
    }
}

