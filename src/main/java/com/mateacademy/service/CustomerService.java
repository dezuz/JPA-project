package com.mateacademy.service;

import com.mateacademy.table.Customer;
import com.mateacademy.table.Developer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerService implements Service<Customer> {
    private EntityManager entityManager =
            Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    @Override
    public Customer add(Customer customer) {
        entityManager.getTransaction().begin();
        Customer customerDB = entityManager.merge(customer);
        entityManager.getTransaction().commit();
        return customerDB;
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(get(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Customer get(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void update(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.merge(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Customer> getAll() {
        TypedQuery<Customer> namedQuery = entityManager.createNamedQuery("Developer.getAll", Customer.class);
        return namedQuery.getResultList();
    }
}
