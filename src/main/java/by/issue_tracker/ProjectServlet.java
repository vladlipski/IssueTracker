package by.issue_tracker;

import by.issue_tracker.db.DbWorker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Projects", urlPatterns = "/test")
public class ProjectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbWorker worker = new DbWorker();
        worker.getConnection();
        request.setAttribute("attributeName", "Vlad");
        RequestDispatcher rd= request.getRequestDispatcher("/projects-list.jsp");
        rd.forward(request, response);
    }
}
