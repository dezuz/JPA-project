package com.mateacademy.table;

import com.mateacademy.service.DeveloperService;
import org.hibernate.SessionFactory;

public class TestClass {
    private DeveloperService developerService = new DeveloperService();

    public static void main(String[] args) {
        SessionFactory sessionFactory = JpaUtil.getSessionFactory();
        sessionFactory.close();
    }
}
