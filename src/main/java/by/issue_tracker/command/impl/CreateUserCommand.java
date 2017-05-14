package by.issue_tracker.command.impl;

import by.issue_tracker.command.Command;
import by.issue_tracker.models.User;
import by.issue_tracker.service.ServiceFactory;
import by.issue_tracker.service.UserService;
import by.issue_tracker.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUserCommand implements Command{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServiceException, ServletException {
        User user = new User();
        user.setFirst_name(request.getParameter("first_name"));
        user.setLast_name(request.getParameter("last_name"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setRole_id(request.getParameter("role_id"));

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();
        userService.createUser(user);
        response.sendRedirect("/users?command=GET_USERS");
    }
}
