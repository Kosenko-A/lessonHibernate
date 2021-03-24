package ru.geekbrains;

import ru.geekbrains.entity.Person;
import ru.geekbrains.entity.Product;
import ru.geekbrains.service.PersonDao;
import ru.geekbrains.service.ProductDao;
import ru.geekbrains.service.ServiceSearch;

public class Application {

    public static void main(String[] args) {

        ProductDao daoProduct = new ProductDao();
        PersonDao daoPerson = new PersonDao();
        ServiceSearch serviceSearch = new ServiceSearch();

        Product product = new Product("skirt", 3000);
        Person person = new Person("George");

        //запросы, которые влияют на содержимое БД были закомментированы

        System.out.println(daoProduct.findById(15L).toString()); //найти товар по id
        System.out.println(daoProduct.findAll()); //вывести список всех товаров
        //daoProduct.deleteById(2L); //удалить товар по id
        //System.out.println(daoProduct.findAll()); //проверка
        //daoProduct.saveOrUpdate(product); //сохранить новый товар
        //System.out.println(daoProduct.findAll()); //проверка

        System.out.println(daoPerson.findById(1L).toString()); //найти покупателя по id
        System.out.println(daoPerson.findAll()); //вывести список всех покупателей
        //daoPerson.deleteById(2L); //удалить покупателя по id
        //System.out.println(daoPerson.findAll()); //проверка
        //daoPerson.saveOrUpdate(person); //сохранить нового покупателя
        //System.out.println(daoPerson.findAll()); //проверка

        System.out.println(serviceSearch.searchProducts(1L)); //найти товары по id покупателя
        System.out.println(serviceSearch.searchPersons(13L)); //найти покупателей по id товара

    }

}
