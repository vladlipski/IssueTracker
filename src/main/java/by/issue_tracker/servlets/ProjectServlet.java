package by.issue_tracker.servlets;

import by.issue_tracker.db.DbWorker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name="Projects", urlPatterns = "/")
public class ProjectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbWorker worker = new DbWorker();
        Connection conn = worker.getConnection();
        worker.closeConnection(conn);
        request.setAttribute("attributeName", "Vlad");
        request.getRequestDispatcher("/views/projects-list.jsp").forward(request, response);
    }
}
