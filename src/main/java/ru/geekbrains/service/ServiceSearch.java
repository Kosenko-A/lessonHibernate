package ru.geekbrains.service;

import ru.geekbrains.entity.Person;
import ru.geekbrains.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class ServiceSearch {

    Manager man = new Manager();
    EntityManager manager =  man.getManager();

    public List<Product> searchProducts(Long idPerson) {
        Query query = manager.createQuery("select p from Product p where person.id = :id", Product.class);
        query.setParameter("id", idPerson);
        List <Product> anotherProduct = null;
        try {
            anotherProduct = (List<Product>) query.getResultList();
        } catch (NoResultException e) {
            System.out.println("Products weren't found");
        }
        return anotherProduct;
    }

    public List<Person> searchPersons(Long idProduct) {
        Query query = manager.createQuery("select p from Person p where product.id = :id", Person.class);
        query.setParameter("id", idProduct);
        List <Person> anotherPerson = null;
        try {
            anotherPerson = (List<Person>) query.getResultList();
        } catch (NoResultException e) {
            System.out.println("Persons weren't found");
        }
        return anotherPerson;
    }
}
