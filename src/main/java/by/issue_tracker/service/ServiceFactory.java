package by.issue_tracker.service;

import by.issue_tracker.service.impl.ProjectServiceImpl;
import by.issue_tracker.service.impl.UserServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final ProjectService projectService = new ProjectServiceImpl();

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
}
