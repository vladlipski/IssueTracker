package by.issue_tracker.controller;

import by.issue_tracker.model.Project;
import by.issue_tracker.service.IProjectService;
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
public class ProjectController {
    private static final String PROJECTS_PAGE = "projects";

    private final IProjectService projectService;

    @Autowired
    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "projects")
    public String getUserPage(Model model) throws ServiceException {
        model.addAttribute("projects", projectService.getAll());
        return PROJECTS_PAGE;
    }

    @RequestMapping(value = "upd-project", method = RequestMethod.POST)
    public RedirectView updateUser(@ModelAttribute Project project) throws ServiceException {
        projectService.update(project);
        return new RedirectView(PROJECTS_PAGE);
    }

    @RequestMapping(value = "del-project", method = RequestMethod.POST)
    public RedirectView deleteUser(@RequestParam("id") int projectId) throws ServiceException {
        projectService.delete(projectId);
        return new RedirectView(PROJECTS_PAGE);
    }

    @RequestMapping(value = "add-project", method = RequestMethod.POST)
    public RedirectView addUser(@ModelAttribute Project project) throws ServiceException {
        projectService.create(project);
        return new RedirectView(PROJECTS_PAGE);
    }

}
