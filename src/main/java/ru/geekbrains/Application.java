package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class Application {

    public static void main(String[] args) {

        ProductDao dao = new ProductDao();
        Product product = new Product("hat", 800);

        System.out.println(dao.findById(1L).toString()); //найти товар по id
        System.out.println(dao.findAll()); //вывести список всех товаров
        dao.deleteById(2L); //удалить товар по id
        System.out.println(dao.findAll()); //проверка
        dao.saveOrUpdate(product); //сохранить новый товар
        System.out.println(dao.findAll()); //проверка


    }

}
