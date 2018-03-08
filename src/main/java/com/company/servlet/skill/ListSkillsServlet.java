package com.company.servlet.skill;

import com.company.model.entities.Skill;
import com.company.model.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/all-skills", name = "listSkills")
public class ListSkillsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SkillService skillService = new SkillService();
        List<Skill> skills = skillService.getAllSkills();
        req.setAttribute("skills", skills);
        req.getRequestDispatcher("/view/skill/list-skills.jsp").forward(req, resp);
    }
}
