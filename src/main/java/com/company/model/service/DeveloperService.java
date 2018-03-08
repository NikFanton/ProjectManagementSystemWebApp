package com.company.model.service;

import com.company.model.dao.DeveloperDAO;
import com.company.model.dao.impl.DeveloperDAOImpl;
import com.company.model.entities.Developer;
import com.company.model.entities.Skill;

import java.util.List;

public class DeveloperService {
    private DeveloperDAO developerDAO = new DeveloperDAOImpl();

    public void addDeveloper(Developer developer) {
        developerDAO.add(developer);
    }

    public Developer getDeveloperById(Long id) {
        return developerDAO.getById(id);
    }

    public List<Developer> getAllDevelopers() {
        return developerDAO.getAll();
    }

    public void updateDeveloper(Developer developer) {
        developerDAO.update(developer);
    }

    public void deleteDeveloper(Long id) {
        developerDAO.delete(id);
    }

    public void addSkillToDeveloper(Long developerId, Skill skill) {
        Developer developer = getDeveloperById(developerId);
        developer.getSkills().add(skill);
        updateDeveloper(developer);
    }
}
