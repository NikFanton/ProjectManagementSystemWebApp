package com.company.servlet.developer;

import com.company.model.entities.Developer;
import com.company.model.service.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/all-developers", name = "listDevelopers")
public class ListDevelopersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeveloperService developerService = new DeveloperService();
        List<Developer> developers = developerService.getAllDevelopers();
        req.setAttribute("developers", developers);
        req.getRequestDispatcher("/view/developer/list-developers.jsp").forward(req, resp);
    }
}
