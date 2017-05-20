package by.issue_tracker.command.impl;

import by.issue_tracker.command.Command;
import by.issue_tracker.service.ServiceFactory;
import by.issue_tracker.service.exception.ServiceException;
import by.issue_tracker.service.interfaces.CommentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCommentsCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServiceException, ServletException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CommentService commentService = serviceFactory.getCommentService();
        Object result = commentService.getAll();
        request.setAttribute("comments", result);
        request.getRequestDispatcher("/views/comments.jsp").forward(request,response);
    }
}
