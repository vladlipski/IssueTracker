package by.issue_tracker.servlets;

import by.issue_tracker.dao.DaoFactory;
import by.issue_tracker.dao.UserDao;
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
        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        List<User> users = userDao.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/views/users-list.jsp").forward(request, response);
    }
}
