package com.mateacademy.service;

import com.mateacademy.table.Developer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class SkillService  implements Service<Developer> {
    private EntityManager entityManager =
            Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    @Override
    public Developer add(Developer developer) {
        entityManager.getTransaction().begin();
        Developer developerDB = entityManager.merge(developer);
        entityManager.getTransaction().commit();
        return developerDB;
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(get(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Developer get(Long id) {
        return entityManager.find(Developer.class, id);
    }

    @Override
    public void update(Developer developer) {
        entityManager.getTransaction().begin();
        entityManager.merge(developer);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Developer> getAll() {
        TypedQuery<Developer> namedQuery = entityManager.createNamedQuery("Developer.getAll", Developer.class);
        return namedQuery.getResultList();
    }
}
