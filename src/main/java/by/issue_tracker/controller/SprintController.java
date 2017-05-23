package by.issue_tracker.controller;

import by.issue_tracker.model.Sprint;
import by.issue_tracker.service.ISprintService;
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
public class SprintController {
    private static final String SPRINTS_PAGE = "sprints";

    private final ISprintService sprintService;

    @Autowired
    public SprintController(ISprintService sprintService) {
        this.sprintService = sprintService;
    }

    @RequestMapping(value = "sprints")
    public String getUserPage(Model model) throws ServiceException {
        model.addAttribute("sprints", sprintService.getAll());
        return SPRINTS_PAGE;
    }

    @RequestMapping(value = "upd-sprint", method = RequestMethod.POST)
    public RedirectView updateUser(@ModelAttribute Sprint sprint) throws ServiceException {
        sprintService.update(sprint);
        return new RedirectView(SPRINTS_PAGE);
    }

    @RequestMapping(value = "del-sprint", method = RequestMethod.POST)
    public RedirectView deleteUser(@RequestParam("id") int sprintId) throws ServiceException {
        sprintService.delete(sprintId);
        return new RedirectView(SPRINTS_PAGE);
    }

    @RequestMapping(value = "add-sprint", method = RequestMethod.POST)
    public RedirectView addUser(@ModelAttribute Sprint sprint) throws ServiceException {
        sprintService.create(sprint);
        return new RedirectView(SPRINTS_PAGE);
    }


}
