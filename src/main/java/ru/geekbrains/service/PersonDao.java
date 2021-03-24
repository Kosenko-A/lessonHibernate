package ru.geekbrains.service;

import javax.persistence.EntityManager;

public class PersonDao {

    Manager man = new Manager();
    EntityManager manager =  man.getManager();
}
