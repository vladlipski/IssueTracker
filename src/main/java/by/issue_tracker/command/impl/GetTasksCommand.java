package by.issue_tracker.command.impl;

import by.issue_tracker.command.Command;
import by.issue_tracker.service.ServiceFactory;
import by.issue_tracker.service.exception.ServiceException;
import by.issue_tracker.service.interfaces.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetTasksCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServiceException, ServletException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TaskService taskService = serviceFactory.getTaskService();
        Object result = taskService.getAll();
        request.setAttribute("tasks", result);
        request.getRequestDispatcher("/views/tasks.jsp").forward(request,response);
    }
}
