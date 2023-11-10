package org.example.lab_3;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public Optional<Product> add(Product product) {
        if (products.contains(product)){
            return Optional.empty();
        }
        products.add(product);
        return Optional.of(product);
    }

    public Optional<Product> remove(Product product) {
        if (!products.contains(product)){
            return Optional.empty();
        }
        products.remove(product);
        return Optional.of(product);
    }

    public Order order() {
        var result = new Order(products);
        products = new ArrayList<>();
        return result;
    }
}