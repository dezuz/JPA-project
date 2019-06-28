package com.mateacademy.service;

import com.mateacademy.table.Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProjectService implements Service<Project> {
    private EntityManager entityManager =
            Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    @Override
    public Project add(Project project) {
        entityManager.getTransaction().begin();
        Project projectDB = entityManager.merge(project);
        entityManager.getTransaction().commit();
        return projectDB;
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(get(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Project get(Long id) {
        return entityManager.find(Project.class, id);
    }

    @Override
    public void update(Project project) {
        entityManager.getTransaction().begin();
        entityManager.merge(project);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Project> getAll() {
        TypedQuery<Project> namedQuery = entityManager.createNamedQuery("Developer.getAll", Project.class);
        return namedQuery.getResultList();
    }
}
