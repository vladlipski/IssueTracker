package by.issue_tracker.command.impl;

import by.issue_tracker.command.Command;
import by.issue_tracker.models.Project;
import by.issue_tracker.service.ProjectService;
import by.issue_tracker.service.ServiceFactory;
import by.issue_tracker.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProjectCommand implements Command{

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServiceException, ServletException {
        Project project = new Project();
        project.setName(request.getParameter("name"));
        project.setCreation_date(request.getParameter("creation_date"));
        project.setDescription(request.getParameter("description"));
        project.setManager_id(request.getParameter("manager_id"));
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ProjectService projectService = serviceFactory.getProjectService();
        projectService.create(project);
        response.sendRedirect("/projects?command=GET_PROJECTS");
    }
}
