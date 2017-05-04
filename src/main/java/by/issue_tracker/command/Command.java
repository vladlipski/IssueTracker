package by.issue_tracker.command;

import by.issue_tracker.dao.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response) throws DaoException, IOException;
}
