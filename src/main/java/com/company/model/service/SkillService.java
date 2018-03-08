package com.company.model.service;

import com.company.model.dao.SkillDAO;
import com.company.model.dao.impl.SkillDAOImpl;
import com.company.model.entities.Skill;

import java.util.List;

public class SkillService {
    private SkillDAO skillDAO = new SkillDAOImpl();

    public void addSkill(Skill skill) {
        for (Skill s : getAllSkills()) {
            if (skill.getSkillName().equals(s.getSkillName()) && skill.getLevel().equals(s.getLevel())) {
                return;
            }
        }
        skillDAO.add(skill);
    }

    public Skill getSkillById(Long id) {
        return skillDAO.getById(id);
    }

    public List<Skill> getAllSkills() {
        return skillDAO.getAll();
    }

    public void updateSkill(Skill skill) {
        skillDAO.update(skill);
    }

    public void deleteSkill(Long id) {
        skillDAO.delete(id);
    }

    public Skill getSkillByInfo(String skillName, String level) {
        for (Skill skill : getAllSkills()) {
            if (skill.getSkillName().equals(skillName) && skill.getLevel().equals(level)) {
                return skill;
            }
        }
        return new Skill(skillName, level);
    }
}
