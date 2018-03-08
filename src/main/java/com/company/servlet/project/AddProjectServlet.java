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

@WebServlet(value = "/add-project", name = "addProject")
public class AddProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/project/add-project.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectService projectService = new ProjectService();
        Project project = new Project();
        Customer customer = projectService.getCustomerByName(req.getParameter("customerName"));
        Company company = projectService.getCompanyByName(req.getParameter("companyName"));
        project.setProjectName(req.getParameter("projectName"));
        project.setCost(Integer.parseInt(req.getParameter("cost")));
        project.setCustomer(customer);
        project.setCompany(company);
        projectService.addProject(project);
        resp.sendRedirect("/ProjectManagementSystemWebApp/all-projects");
    }
}
