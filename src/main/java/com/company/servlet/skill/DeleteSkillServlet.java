package com.company.servlet.skill;

import com.company.model.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete-skill", name = "deleteSkill")
public class DeleteSkillServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SkillService skillService = new SkillService();
        Long skillId = Long.valueOf(req.getParameter("skillId"));
        skillService.deleteSkill(skillId);
        resp.sendRedirect("/ProjectManagementSystemWebApp/all-skills");
    }
}
