package com.company.servlet.project;

import com.company.model.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete-project", name = "deleteProject")
public class DeleteProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectService projectService = new ProjectService();
        Long projectId = Long.valueOf(req.getParameter("projectId"));
        projectService.deleteProject(projectId);
        resp.sendRedirect("/ProjectManagementSystemWebApp/all-projects");
    }
}
