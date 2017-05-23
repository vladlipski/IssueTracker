package by.issue_tracker.controller;

import by.issue_tracker.model.User;
import by.issue_tracker.service.IUserService;
import by.issue_tracker.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private static final String USERS_PAGE = "users";
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users")
    public String getUserPage(Model model) throws ServiceException {
        model.addAttribute("users", userService.getAll());
        return USERS_PAGE;
    }

    @RequestMapping(value = "upd-user", method = RequestMethod.POST)
    public RedirectView updateUser(@ModelAttribute User user, HttpSession session) throws ServiceException {
        userService.update(user);
        return new RedirectView(USERS_PAGE);
    }

    @RequestMapping(value = "del-user", method = RequestMethod.POST)
    public RedirectView deleteUser(@RequestParam("id") int userId) throws ServiceException {
        userService.delete(userId);
        return new RedirectView(USERS_PAGE);
    }

    @RequestMapping(value = "add-user", method = RequestMethod.POST)
    public RedirectView addUser(@ModelAttribute User user) throws ServiceException {
        userService.create(user);
        return new RedirectView(USERS_PAGE);
    }

}
