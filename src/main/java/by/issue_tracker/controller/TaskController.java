package by.issue_tracker.controller;

import by.issue_tracker.model.Task;
import by.issue_tracker.service.ITaskService;
import by.issue_tracker.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TaskController {
    private static final String TASKS_PAGE = "tasks";

    private final ITaskService taskService;

    @Autowired
    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "tasks")
    public String getUserPage(Model model) throws ServiceException {
        model.addAttribute("tasks", taskService.getAll());
        return TASKS_PAGE;
    }

    @RequestMapping(value = "upd-task", method = RequestMethod.POST)
    public RedirectView updateUser(@ModelAttribute Task task) throws ServiceException {
        taskService.update(task);
        return new RedirectView(TASKS_PAGE);
    }

    @RequestMapping(value = "del-task", method = RequestMethod.POST)
    public RedirectView deleteUser(@RequestParam("id") int taskId) throws ServiceException {
        taskService.delete(taskId);
        return new RedirectView(TASKS_PAGE);
    }

    @RequestMapping(value = "add-task", method = RequestMethod.POST)
    public RedirectView addUser(@ModelAttribute Task task) throws ServiceException {
        taskService.create(task);
        return new RedirectView(TASKS_PAGE);
    }

}
