package by.issue_tracker.servlets;

import by.issue_tracker.command.Command;
import by.issue_tracker.command.factory.CommandRepository;
import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.models.User;
import by.issue_tracker.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static final String COMMAND_PARAMETER = "command";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        analyzeRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        analyzeRequest(request, response);
    }

    private String getCommand(HttpServletRequest request) {
        String command = request.getParameter("action");
        if (command == null) {
            command = request.getParameter(COMMAND_PARAMETER);
        }
        return command;
    }

    private void analyzeRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = getCommand(request);
        CommandRepository factory = CommandRepository.getInstance();
        Command command = factory.getCommand(commandName);
        try {
            command.execute(request, response);
        } catch (Exception e) {
            response.sendError(500);
        }
    }
}
