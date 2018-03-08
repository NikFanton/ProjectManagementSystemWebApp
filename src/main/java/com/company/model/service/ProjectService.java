package com.company.model.service;

import com.company.model.dao.CompanyDAO;
import com.company.model.dao.CustomerDAO;
import com.company.model.dao.DeveloperDAO;
import com.company.model.dao.ProjectDAO;
import com.company.model.dao.impl.CompanyDAOImpl;
import com.company.model.dao.impl.CustomerDAOImpl;
import com.company.model.dao.impl.DeveloperDAOImpl;
import com.company.model.dao.impl.ProjectDAOImpl;
import com.company.model.entities.Company;
import com.company.model.entities.Customer;
import com.company.model.entities.Developer;
import com.company.model.entities.Project;

import java.util.List;

public class ProjectService {
    private ProjectDAO projectDAO = new ProjectDAOImpl();

    public void addProject(Project project) {
        projectDAO.add(project);
    }

    public Project getProjectById(Long id) {
        return projectDAO.getById(id);
    }

    public List<Project> getAllProjects() {
        return projectDAO.getAll();
    }

    public void updateProject(Project project) {
        projectDAO.update(project);
    }

    public void deleteProject(Long id) {
        projectDAO.delete(id);
    }

    public Customer getCustomerByName(String customerName) {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        Customer resultCustomer = null;
        for (Customer customer : customerDAO.getAll()) {
            if (customer.getCustomerName().equals(customerName)) {
                return customer;
            }
        }
        return new Customer(customerName);
    }

    public Company getCompanyByName(String companyName) {
        CompanyDAO companyDAO = new CompanyDAOImpl();
        for (Company company : companyDAO.getAll()) {
            if (company.getCompanyName().equals(companyName)) {
                return company;
            }
        }
        return new Company(companyName, 0);
    }

    public Project getProjectByName(String projectName) {
        for (Project project : getAllProjects()) {
            if (project.getProjectName().equals(projectName)) {
                return project;
            }
        }
        return null;
    }

    public void addDeveloperToProject(Long developerId, String projectName) {
        Project project = getProjectByName(projectName);
        DeveloperDAO developerDAO = new DeveloperDAOImpl();
        if (project != null) {
            Developer developer = developerDAO.getById(developerId);
            developer.getProjects().add(project);
            developerDAO.update(developer);
        }
    }
}
