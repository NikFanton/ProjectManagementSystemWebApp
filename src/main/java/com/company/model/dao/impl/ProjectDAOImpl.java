package com.company.model.dao.impl;

import com.company.model.dao.ProjectDAO;
import com.company.model.entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {
    public SessionFactory sessionFactory;

    public ProjectDAOImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void add(Project project) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(project);
        if (project.getCustomer() != null) {
            session.saveOrUpdate(project.getCustomer());
        }
        if (project.getCompany() != null) {
            session.saveOrUpdate(project.getCompany());
        }
        if (project.getDevelopers() != null) {
            project.getDevelopers().forEach(d -> session.saveOrUpdate(d));
        }
        transaction.commit();
        session.close();
    }

    @Override
    public Project getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Project project = session.get(Project.class, id);
        transaction.commit();
        session.close();
        return project;
    }

    @Override
    public List<Project> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("FROM Project");
        List result = query.list();
        session.close();
        return result;
    }

    @Override
    public void update(Project project) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(project);
        if (project.getCustomer() != null) {
            session.saveOrUpdate(project.getCustomer());
        }
        if (project.getCompany() != null) {
            session.saveOrUpdate(project.getCompany());
        }
        if (project.getDevelopers() != null) {
            project.getDevelopers().forEach(developer -> session.saveOrUpdate(developer));
        }
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Project project = session.get(Project.class, id);
        project.setDevelopers(null);
        session.delete(project);
        transaction.commit();
        session.close();
    }
}
