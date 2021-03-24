package ru.geekbrains.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List <Product> productList;

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, list: %s", id, name, productList.toString());
    }

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
