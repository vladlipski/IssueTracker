package by.issue_tracker.command.impl;

import by.issue_tracker.command.Command;
import by.issue_tracker.models.Sprint;
import by.issue_tracker.service.ServiceFactory;
import by.issue_tracker.service.exception.ServiceException;
import by.issue_tracker.service.interfaces.SprintService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateSprintCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServiceException, ServletException {
        Sprint sprint = new Sprint();
        sprint.setName(request.getParameter("name"));
        sprint.setStart_date(request.getParameter("start_date("));
        sprint.setEnd_date(request.getParameter("end_date"));
        sprint.setProject_id(request.getParameter("project_id"));

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SprintService sprintService = serviceFactory.getSprintService();
        sprintService.create(sprint);
        response.sendRedirect("/sprints?command=GET_SPRINTS");
    }
}