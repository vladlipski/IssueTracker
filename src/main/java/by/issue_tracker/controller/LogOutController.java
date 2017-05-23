package by.issue_tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class LogOutController {
    private static final String LOGIN_PAGE = "login";

    @RequestMapping(value = "logOut")
    public RedirectView logOut(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return new RedirectView(LOGIN_PAGE);
    }
}
