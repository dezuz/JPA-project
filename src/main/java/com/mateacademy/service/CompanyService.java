package com.mateacademy.service;

import com.mateacademy.table.Company;
import com.mateacademy.table.Developer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CompanyService implements Service<Company> {
    private EntityManager entityManager =
            Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    @Override
    public Company add(Company company) {
        entityManager.getTransaction().begin();
        Company companyDB = entityManager.merge(company);
        entityManager.getTransaction().commit();
        return companyDB;
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(get(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Company get(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void update(Company company) {
        entityManager.getTransaction().begin();
        entityManager.merge(company);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Company> getAll() {
        TypedQuery<Company> namedQuery = entityManager.createNamedQuery("Developer.getAll", Company.class);
        return namedQuery.getResultList();
    }
}
