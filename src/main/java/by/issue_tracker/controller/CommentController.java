package by.issue_tracker.controller;

import by.issue_tracker.model.Comment;
import by.issue_tracker.service.ICommentService;
import by.issue_tracker.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CommentController {
    private static final String COMMENTS_PAGE = "comments";

    private final ICommentService commentService;

    @RequestMapping(value = "comments")
    public String getUserPage(Model model) throws ServiceException {
        model.addAttribute("comments", commentService.getAll());
        return COMMENTS_PAGE;
    }

    @RequestMapping(value = "upd-comment", method = RequestMethod.POST)
    public RedirectView updateUser(@ModelAttribute Comment comment) throws ServiceException {
        commentService.update(comment);
        return new RedirectView(COMMENTS_PAGE);
    }

    @RequestMapping(value = "del-comment", method = RequestMethod.POST)
    public RedirectView deleteUser(@RequestParam("id") int projectId) throws ServiceException {
        commentService.delete(projectId);
        return new RedirectView(COMMENTS_PAGE);
    }

    @RequestMapping(value = "add-comment", method = RequestMethod.POST)
    public RedirectView addUser(@ModelAttribute Comment comment) throws ServiceException {
        commentService.create(comment);
        return new RedirectView(COMMENTS_PAGE);
    }

    @Autowired
    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

}
