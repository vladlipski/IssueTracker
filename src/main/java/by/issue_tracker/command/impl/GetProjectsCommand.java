package by.issue_tracker.command.impl;

import by.issue_tracker.command.Command;
import by.issue_tracker.service.interfaces.ProjectService;
import by.issue_tracker.service.ServiceFactory;
import by.issue_tracker.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetProjectsCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServiceException, ServletException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ProjectService projectService = serviceFactory.getProjectService();
        Object result = projectService.getAll();
        request.setAttribute("projects", result);
        request.getRequestDispatcher("/views/projects.jsp").forward(request,response);
    }
}
