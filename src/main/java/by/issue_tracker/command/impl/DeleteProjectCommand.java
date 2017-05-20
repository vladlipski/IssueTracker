package by.issue_tracker.command.impl;

import by.issue_tracker.command.Command;
import by.issue_tracker.service.ProjectService;
import by.issue_tracker.service.ServiceFactory;
import by.issue_tracker.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProjectCommand implements Command{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServiceException, ServletException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ProjectService projectService = serviceFactory.getProjectService();
        projectService.delete(Integer.parseInt(request.getParameter("project_id")));
        response.sendRedirect("/projects?command=GET_PROJECTS");
    }
}
