package by.issue_tracker.service;

import by.issue_tracker.service.impl.*;
import by.issue_tracker.service.interfaces.*;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final ProjectService projectService = new ProjectServiceImpl();
    private final SprintService sprintService = new SprintServiceImpl();
    private final TaskService taskService = new TaskServiceImpl();
    private final CommentService commentService = new CommentServiceImpl();
    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public UserService getUserService(){
        return userService;
    }

    public ProjectService getProjectService(){
        return projectService;
    }

    public SprintService getSprintService(){
        return sprintService;
    }

    public TaskService getTaskService(){
        return taskService;
    }

    public CommentService getCommentService(){
        return commentService;
    }
}
