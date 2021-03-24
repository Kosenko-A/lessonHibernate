package ru.geekbrains.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product")

public class Product {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 128)
    private String title;

    @Column(name = "price")
    private int price;


    public Product() {
        UUID.randomUUID();
    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "product_id")
    private Person person;

    @Override
    public String toString() {
        return String.format("id: %s, title: %s, price: %s, customer: %s", id, title, price, person!= null ? person.getName() : "");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
