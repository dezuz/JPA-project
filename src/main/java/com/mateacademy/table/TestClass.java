package com.mateacademy.table;

import org.hibernate.SessionFactory;

public class TestClass {
    public static void main(String[] args) {
        SessionFactory sessionFactory = JpaUtil.getSessionFactory();
        sessionFactory.close();
    }
}
