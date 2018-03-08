package com.company.servlet.developer;

import com.company.model.entities.Developer;
import com.company.model.service.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete-developer", name = "deleteDeveloper")
public class DeleteDeveloperServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeveloperService developerService = new DeveloperService();
        Long id = Long.valueOf(req.getParameter("developerId"));
        developerService.deleteDeveloper(id);
        resp.sendRedirect("/ProjectManagementSystemWebApp/all-developers");
    }
}
