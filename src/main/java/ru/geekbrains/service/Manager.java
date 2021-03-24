package ru.geekbrains.service;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Manager {

    EntityManagerFactory factory = new Configuration()
            .configure("hibernate.xml")
            .buildSessionFactory();

    EntityManager manager = factory.createEntityManager();

    public EntityManager getManager() {
        return manager;
    }
}
