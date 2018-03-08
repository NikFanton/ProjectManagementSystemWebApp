package com.company.servlet.project;

import com.company.model.entities.Project;
import com.company.model.service.ProjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/all-projects", name = "listProjects")
public class ListProjectsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectService projectService = new ProjectService();
        List<Project> projects = projectService.getAllProjects();
        req.setAttribute("projects", projects);
        req.getRequestDispatcher("/view/project/list-projects.jsp").forward(req, resp);
    }
}
