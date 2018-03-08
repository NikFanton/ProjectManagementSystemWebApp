package com.company.servlet.skill;

import com.company.model.entities.Skill;
import com.company.model.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/edit-skill", name = "editSkill")
public class EditSkillServlet extends HttpServlet{
    SkillService skillService = new SkillService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long skillId = Long.valueOf(req.getParameter("skillId"));
        Skill skill = skillService.getSkillById(skillId);
        req.setAttribute("skill", skill);
        req.getRequestDispatcher("/view/skill/edit-skill.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Object paramName : req.getParameterMap().keySet()) {
            System.out.println(paramName.toString() + "=" + req.getParameter((String) paramName));
        }
        Long skillId = Long.valueOf(req.getParameter("skillId"));
        Skill skill = skillService.getSkillById(skillId);
        skill.setSkillName(req.getParameter("skillName"));
        skill.setLevel(req.getParameter("level"));
        skillService.updateSkill(skill);
        resp.sendRedirect("/ProjectManagementSystemWebApp/all-skills");
    }
}
