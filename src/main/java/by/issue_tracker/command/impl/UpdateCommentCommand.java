package by.issue_tracker.command.impl;

import by.issue_tracker.command.Command;
import by.issue_tracker.models.Comment;
import by.issue_tracker.service.ServiceFactory;
import by.issue_tracker.service.exception.ServiceException;
import by.issue_tracker.service.interfaces.CommentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCommentCommand implements Command {
   public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServiceException, ServletException {
       Comment comment = new Comment();
       comment.setId(request.getParameter("comment_id"));
       comment.setContent(request.getParameter("content"));
       comment.setAuthor_id(request.getParameter("author_id"));
       comment.setTask_id(request.getParameter("task_id"));


       ServiceFactory serviceFactory = ServiceFactory.getInstance();
       CommentService commentService = serviceFactory.getCommentService();
       commentService.update(comment);
       response.sendRedirect("/comments?command=GET_COMMENTS");
   }
}
