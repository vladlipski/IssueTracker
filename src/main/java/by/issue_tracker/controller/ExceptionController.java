package by.issue_tracker.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
@Controller
public class ExceptionController {

    private static final Logger logger = Logger.getLogger(ExceptionController.class);
    private static final String ERROR_PAGE = "error";

    @ExceptionHandler(Exception.class)
    public RedirectView exception(Exception ex) {
        logger.error(ex);
        return new RedirectView(ERROR_PAGE);
    }

    @RequestMapping(value = "error")
    public String errorPage() {
        return ERROR_PAGE;
    }
}
