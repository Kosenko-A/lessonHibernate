package ru.geekbrains.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Person;
import ru.geekbrains.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Service
public class PersonDao {

    Manager man = new Manager();
    EntityManager manager =  man.getManager();

    public Person findById(Long id) {
        Query query = manager.createQuery("select p from Person p where p.id = :id");
        query.setParameter("id", id);
        Person anotherPerson;
        try {
            anotherPerson = (Person) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("This person wasn't found");
            anotherPerson = new Person();
        }
        return anotherPerson;
    }

    public List<Person> findAll() {
        Query query = manager.createQuery("select p from Person p");
        List <Person> anotherPerson = null;
        try {
            anotherPerson = (List<Person>) query.getResultList();
        } catch (NoResultException e) {
            System.out.println("Persons weren't found");
        }
        return anotherPerson;
    }

    public void deleteById(Long id) {
        manager.getTransaction().begin();
        Person person = findById(id);
        manager.remove(person);
        manager.getTransaction().commit();
    }

    public Person saveOrUpdate(Person person) {
        manager.getTransaction().begin();
        manager.persist(person);
        manager.getTransaction().commit();
        return person;
    }
}
