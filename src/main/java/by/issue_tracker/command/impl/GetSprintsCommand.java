package by.issue_tracker.command.impl;

import by.issue_tracker.command.Command;
import by.issue_tracker.service.ServiceFactory;
import by.issue_tracker.service.exception.ServiceException;
import by.issue_tracker.service.interfaces.SprintService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetSprintsCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServiceException, ServletException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SprintService sprintService = serviceFactory.getSprintService();
        Object result = sprintService.getAll();
        request.setAttribute("sprints", result);
        request.getRequestDispatcher("/views/sprints.jsp").forward(request,response);
    }
}
