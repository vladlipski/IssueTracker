package by.issue_tracker.command.impl;

import by.issue_tracker.command.Command;
import by.issue_tracker.models.Task;
import by.issue_tracker.service.ServiceFactory;
import by.issue_tracker.service.exception.ServiceException;
import by.issue_tracker.service.interfaces.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateTaskCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServiceException, ServletException {
        Task task = new Task();
        task.setDescription(request.getParameter("description"));
        task.setDue_date(request.getParameter("due_date"));
        task.setName(request.getParameter("name"));
        task.setDone(request.getParameter("done"));
        task.setSprint_id(request.getParameter("sprint_id"));
        task.setPerformer_id(request.getParameter("performer_id"));

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TaskService taskService = serviceFactory.getTaskService();
        taskService.create(task);
        response.sendRedirect("/tasks?command=GET_TASKS");
    }
}