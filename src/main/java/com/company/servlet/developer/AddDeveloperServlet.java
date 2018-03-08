package com.company.servlet.developer;

import com.company.model.entities.Developer;
import com.company.model.service.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add-dev", name = "addDeveloper")
public class AddDeveloperServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/developer/add-developer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeveloperService developerService = new DeveloperService();
        Developer developer = new Developer();
        developer.setName(req.getParameter("name"));
        developer.setAge(Integer.parseInt(req.getParameter("age")));
        developer.setSex(req.getParameter("sex"));
        developer.setSalary(Integer.parseInt(req.getParameter("salary")));
        developerService.addDeveloper(developer);
        resp.sendRedirect("/ProjectManagementSystemWebApp/all-developers");
    }
}
