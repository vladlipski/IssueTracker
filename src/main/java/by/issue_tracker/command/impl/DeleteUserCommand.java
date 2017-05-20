package by.issue_tracker.command.impl;


import by.issue_tracker.command.Command;
import by.issue_tracker.service.ServiceFactory;
import by.issue_tracker.service.interfaces.UserService;
import by.issue_tracker.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserCommand implements Command{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServiceException, ServletException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();
        userService.delete(Integer.parseInt(request.getParameter("user_id")));
        response.sendRedirect("/users?command=GET_USERS");
    }
}
