package by.issue_tracker.servlets;

import by.issue_tracker.dao.UserMySqlDao;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.dao.interfaces.UserDao;
import by.issue_tracker.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "Users", urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserMySqlDao();
        List<User> users = null;
        try {
            users = userDao.getAll();
        } catch (DaoException ignored) {
        }
        request.setAttribute("users", users);
        request.getRequestDispatcher("/views/users-list.jsp").forward(request, response);
    }
}
