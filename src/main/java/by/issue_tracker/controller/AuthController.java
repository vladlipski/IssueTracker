package by.issue_tracker.controller;

import by.issue_tracker.model.User;
import by.issue_tracker.model.dto.UserSignUpDTO;
import by.issue_tracker.service.IUserService;
import by.issue_tracker.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@SessionAttributes("user")
public class AuthController {
    private static final String USERS_PAGE = "users";
    private static final String LOGIN_PAGE = "login";
    private static final String SIGN_UP_PAGE = "signup";
    private final IUserService userService;

    @Autowired
    public AuthController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return LOGIN_PAGE;
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String signUpPage() {
        return SIGN_UP_PAGE;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public RedirectView login(Model model, @RequestParam("email") String email, @RequestParam("password") String password) throws ServiceException {
        User user = userService.logIn(email, password);
        if (user != null) {
            model.addAttribute("user", user);
            return new RedirectView(USERS_PAGE);
        }
        return new RedirectView(LOGIN_PAGE);
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public RedirectView signUp(@ModelAttribute UserSignUpDTO user) throws ServiceException {
        if (checkPasswords(user) && userService.signUp(user)) {
            return new RedirectView(LOGIN_PAGE);
        }
        return new RedirectView(SIGN_UP_PAGE);
    }

    private boolean checkPasswords(UserSignUpDTO user) {
        return user.getPassword().equals(user.getVerifyPassword());
    }
}
