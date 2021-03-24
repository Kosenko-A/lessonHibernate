package ru.geekbrains.service;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Service
public class ProductDao {

    Manager man = new Manager();
    EntityManager manager =  man.getManager();

    Product product = new Product("skirt", 1000);

    public Product findById(Long id) {
        Query query = manager.createQuery("select p from Product p where p.id = :id");
        query.setParameter("id", id);
        Product anotherProduct;
        try {
            anotherProduct = (Product)query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("This product wasn't found");
            anotherProduct = new Product();
        }
        return anotherProduct;
    }

    public List<Product> findAll() {
        Query query = manager.createQuery("select p from Product p");
        List <Product> anotherProduct = null;
        try {
            anotherProduct = (List<Product>) query.getResultList();
        } catch (NoResultException e) {
            System.out.println("Products weren't found");
        }
        return anotherProduct;
    }

    public void deleteById(Long id) {
        manager.getTransaction().begin();
        Product product = findById(id);
        manager.remove(product);
        manager.getTransaction().commit();
    }

    public Product saveOrUpdate(Product product) {
        manager.getTransaction().begin();
        manager.persist(product);
        manager.getTransaction().commit();
        return product;
    }
}
