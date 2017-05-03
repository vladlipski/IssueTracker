package by.issue_tracker.servlets;

import by.issue_tracker.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        analyzeRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        analyzeRequest(request, response);
    }

    private String getCommand(HttpServletRequest request) {
        String command = request.getParameter("command");
        if (command != null) {
            return request.getParameter("command");
        }
        return "";
    }

    private void analyzeRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        User user = (User)session.getAttribute("USER");
        if (user != null || getCommand(request).equals("SIGN_IN")) {
            if (request.getMethod().equals("POST")) {
                System.out.println("POST");
            } else {
                System.out.println("GET");
            }
        } else {
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }
}
