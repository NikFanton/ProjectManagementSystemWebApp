package com.company.servlet.project;

import com.company.model.entities.Company;
import com.company.model.entities.Customer;
import com.company.model.entities.Project;
import com.company.model.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/edit-project", name = "editProject")
public class EditProjectServlet extends HttpServlet {
    private ProjectService projectService = new ProjectService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long projectId = Long.valueOf(req.getParameter("projectId"));
        Project project = projectService.getProjectById(projectId);
        req.setAttribute("project", project);
        req.getRequestDispatcher("/view/project/edit-project.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long projectId = Long.valueOf(req.getParameter("projectId"));
        Project project = projectService.getProjectById(projectId);
        project.setProjectName(req.getParameter("projectName"));
        project.setCost(Integer.parseInt(req.getParameter("cost")));
        projectService.updateProject(project);
        resp.sendRedirect("/ProjectManagementSystemWebApp/all-projects");
    }
}
