package org.example.lab_3;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Product {
    private final String id;
    private final String name;
    private final int price;

    public Product(String name, int price) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }
}