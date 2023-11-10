package org.example.lab_3;


import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Order {
    private final String id;
    private final List<Product> products;
    private Status status;

    public Order(List<Product> products) {
        id = UUID.randomUUID().toString();
        this.products = products;
        status = Status.Pending;
    }

    public void setStatusShipped() {
        status = Status.Shipped;
    }
}