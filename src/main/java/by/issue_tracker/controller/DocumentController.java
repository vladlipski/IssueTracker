package by.issue_tracker.controller;

import by.issue_tracker.service.*;
import by.issue_tracker.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DocumentController {
    private final static Logger logger = Logger.getLogger(DocumentController.class);

    private final IUserService userService;
    private final ISprintService sprintService;
    private final ITaskService taskService;
    private final IProjectService projectService;

    @Autowired
    public DocumentController(
        IUserService userService,
        ISprintService sprintService,
        ITaskService taskService,
        IProjectService projectService
    ) {
        this.userService = userService;
        this.sprintService = sprintService;
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @RequestMapping(value = "generate-task-report-pdf", method = RequestMethod.POST, produces = "application/pdf")
    public ResponseEntity generateTaskReportPdf(@RequestParam("id") int taskId) throws ServiceException {
        logger.info(taskId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "generate-task-report-csv", method = RequestMethod.POST, produces = "text/csv")
    public ResponseEntity generateTaskReportCsv(@RequestParam("id") int taskId) throws ServiceException {
        logger.info(taskId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "generate-task-report-xls", method = RequestMethod.POST, produces = "application/xlsx")
    public ResponseEntity generateTaskReportXls(@RequestParam("id") int taskId) throws ServiceException {
        logger.info(taskId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "generate-user-tasks-report-pdf", method = RequestMethod.POST, produces = "application/pdf")
    public ResponseEntity generateUserTasksReportPdf(@RequestParam("id") int userId) throws ServiceException {
        logger.info(userId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "generate-user-tasks-report-csv", method = RequestMethod.POST, produces = "text/csv")
    public ResponseEntity generateUserTasksReportCsv(@RequestParam("id") int userId) throws ServiceException {
        logger.info(userId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "generate-user-tasks-report-xls", method = RequestMethod.POST, produces = "application/xlsx")
    public ResponseEntity generateUserTasksReportXls(@RequestParam("id") int userId) throws ServiceException {
        logger.info(userId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "generate-sprint-tasks-report-pdf", method = RequestMethod.POST, produces = "application/pdf")
    public ResponseEntity generateSprintTasksReportPdf(@RequestParam("id") int sprintId) throws ServiceException {
        logger.info(sprintId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "generate-sprint-tasks-report-csv", method = RequestMethod.POST, produces = "text/csv")
    public ResponseEntity generateSprintTasksReportCsv(@RequestParam("id") int sprintId) throws ServiceException {
        logger.info(sprintId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "generate-sprint-tasks-report-xls", method = RequestMethod.POST, produces = "application/xlsx")
    public ResponseEntity generateSprintTasksReportXls(@RequestParam("id") int sprintId) throws ServiceException {
        logger.info(sprintId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "generate-project-tasks-report-pdf", method = RequestMethod.POST, produces = "application/pdf")
    public ResponseEntity generateProjectTasksReportPdf(@RequestParam("id") int projectId) throws ServiceException {
        logger.info(projectId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "generate-project-tasks-report-csv", method = RequestMethod.POST, produces = "text/csv")
    public ResponseEntity generateProjectTasksReportCsv(@RequestParam("id") int projectId) throws ServiceException {
        logger.info(projectId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "generate-project-tasks-report-xls", method = RequestMethod.POST, produces = "application/xlsx")
    public ResponseEntity generateProjectTasksReportXls(@RequestParam("id") int projectId) throws ServiceException {
        logger.info(projectId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "generate-users-with-max-tasks-report-pdf", method = RequestMethod.POST, produces = "application/pdf")
    public ResponseEntity generateUsersWithMaxTasksReportPdf() throws ServiceException {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "generate-users-with-max-tasks-report-csv", method = RequestMethod.POST, produces = "text/csv")
    public ResponseEntity generateUsersWithMaxTasksReportCsv() throws ServiceException {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "generate-users-with-max-tasks-report-xls", method = RequestMethod.POST, produces = "application/xlsx")
    public ResponseEntity generateUsersWithMaxTasksReportXls() throws ServiceException {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }
}
