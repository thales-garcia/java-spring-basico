package com.java.spring.javaspringbasico.model;

import javax.persistence.*;

@Entity
@Table (name="Produtos")
public class ProdutoModelo {

    @Id  //Aponta que essa será a chave primária
    @GeneratedValue(strategy=GenerationType.IDENTITY)  //Autoincrementa
    @Column(name="Id")
    private long id;

    @Column(name="Name")
    private String name;

    @Column(name="Price")
    private double price;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
