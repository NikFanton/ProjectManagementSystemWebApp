package com.company.servlet.developer;

import com.company.model.entities.Developer;
import com.company.model.service.DeveloperService;
import com.company.model.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/connect-to-project", name = "connectToProject")
public class ConnectToProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeveloperService developerService = new DeveloperService();
        Long developerId = Long.valueOf(req.getParameter("developerId"));
        Developer developer = developerService.getDeveloperById(developerId);
        req.setAttribute("developer", developer);
        req.getRequestDispatcher("/view/developer/connect-to-project.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectService projectService = new ProjectService();
        Long developerId = Long.valueOf(req.getParameter("developerId"));
        String projectName = req.getParameter("projectName");
        System.out.println(projectName);
        projectService.addDeveloperToProject(developerId, projectName);
        resp.sendRedirect("/ProjectManagementSystemWebApp/all-developers");
    }
}
