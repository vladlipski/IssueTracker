package by.issue_tracker.command.impl;

import by.issue_tracker.command.Command;
import by.issue_tracker.models.User;
import by.issue_tracker.service.impl.AccountService;
import by.issue_tracker.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignInCommand implements Command {
    private static final String EMAIL_PARAMETER = "email";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String USER = "USER";


    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IOException {
        String email = request.getParameter(EMAIL_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);
        AccountService service = new AccountService();

        User user = service.signIn(email, password);

        HttpSession session = request.getSession(true);
        if (user != null) {
            session.setAttribute(USER, user);
        } else {
            response.sendError(401);
        }
    }
}
