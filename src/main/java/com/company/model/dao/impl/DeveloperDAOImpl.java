package com.company.model.dao.impl;

import com.company.model.dao.DeveloperDAO;
import com.company.model.entities.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeveloperDAOImpl implements DeveloperDAO {
    public SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public void add(Developer developer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(developer);
        if (developer.getSkills() != null) {
            developer.getSkills().forEach(skill -> session.saveOrUpdate(skill));
        }
        if (developer.getProjects() != null) {
            developer.getProjects().forEach(project -> session.saveOrUpdate(project));
        }
        transaction.commit();
        session.close();
    }

    @Override
    public Developer getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class, id);
        transaction.commit();
        session.close();
        return developer;
    }

    @Override
    public List<Developer> getAll() {
        Session session = this.sessionFactory.openSession();
        List result = session.createQuery("FROM Developer").list();
        session.close();
        return result;
    }

    @Override
    public void update(Developer developer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(developer);
        if (developer.getSkills() != null) {
            developer.getSkills().forEach(skill -> session.saveOrUpdate(skill));
        }
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class, id);
        developer.setProjects(null);
        session.delete(developer);
        transaction.commit();
        session.close();
    }
}
