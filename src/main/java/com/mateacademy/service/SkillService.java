package com.mateacademy.service;

import com.mateacademy.table.Skill;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class SkillService implements Service<Skill> {
    private EntityManager entityManager =
            Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    @Override
    public Skill add(Skill skill) {
        entityManager.getTransaction().begin();
        Skill skillDB = entityManager.merge(skill);
        entityManager.getTransaction().commit();
        return skillDB;
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(get(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Skill get(Long id) {
        return entityManager.find(Skill.class, id);
    }

    @Override
    public void update(Skill skill) {
        entityManager.getTransaction().begin();
        entityManager.merge(skill);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Skill> getAll() {
        TypedQuery<Skill> namedQuery = entityManager.createNamedQuery("Developer.getAll", Skill.class);
        return namedQuery.getResultList();
    }
}
