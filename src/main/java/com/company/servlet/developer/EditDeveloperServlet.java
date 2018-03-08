package com.company.servlet.developer;

import com.company.model.entities.Developer;
import com.company.model.service.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/edit-developer", name = "editDeveloper")
public class EditDeveloperServlet extends HttpServlet {
    private DeveloperService developerService = new DeveloperService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long developerId = Long.valueOf(req.getParameter("developerId"));
        Developer developer = developerService.getDeveloperById(developerId);
        req.setAttribute("developer", developer);
        req.getRequestDispatcher("/view/developer/edit-developer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long developerId = Long.valueOf(req.getParameter("developerId"));
        for (Object paramName : req.getParameterMap().keySet()) {
            System.out.println(paramName.toString() + "=" + req.getParameter((String) paramName));
        }
        Developer developer = developerService.getDeveloperById(developerId);
        developer.setName(req.getParameter("name"));
        developer.setAge(Integer.parseInt(req.getParameter("age")));
        developer.setSex(req.getParameter("sex"));
        developer.setSalary(Integer.parseInt(req.getParameter("salary")));
        developerService.updateDeveloper(developer);
        resp.sendRedirect("/ProjectManagementSystemWebApp/all-developers");
    }
}
