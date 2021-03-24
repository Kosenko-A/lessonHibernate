package ru.geekbrains.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Person;
import ru.geekbrains.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Service
public class ServiceSearch {

    Manager man = new Manager();
    EntityManager manager =  man.getManager();

    public List<Product> searchProducts(Long idPerson) {
        Query query = manager.createQuery("select p from Person p where p.id = :id");
        query.setParameter("id", idPerson);
        Person person = (Person) query.getSingleResult();
        return person.getProductList();
    }

    public List<Person> searchPersons(Long idProduct) {
        Query query = manager.createQuery("select p from Product p where p.id = :id");
        query.setParameter("id", idProduct);
        Product product = (Product) query.getSingleResult();
        return product.getPersonList();
    }
}
