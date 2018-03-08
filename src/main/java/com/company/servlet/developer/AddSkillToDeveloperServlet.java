package com.company.servlet.developer;

import com.company.model.entities.Developer;
import com.company.model.entities.Skill;
import com.company.model.service.DeveloperService;
import com.company.model.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add-skill-to-developer", name = "addSkillToDeveloper")
public class AddSkillToDeveloperServlet extends HttpServlet {
    private DeveloperService developerService = new DeveloperService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long developerId = Long.valueOf(req.getParameter("developerId"));
        Developer developer = developerService.getDeveloperById(developerId);
        req.setAttribute("developer", developer);
        req.getRequestDispatcher("/view/developer/add-skill-to-developer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SkillService skillService = new SkillService();
        Long developerId = Long.valueOf(req.getParameter("developerId"));
        String skillName = req.getParameter("skillName");
        String level = req.getParameter("level");
        Skill skill = skillService.getSkillByInfo(skillName, level);
        developerService.addSkillToDeveloper(developerId, skill);
        resp.sendRedirect("/ProjectManagementSystemWebApp/all-developers");
    }
}
