package org.example.lab_7;

import lombok.*;
import org.example.lab_7.exceptions.NegativeStockException;

@Getter
@AllArgsConstructor
@ToString
public class Product {
    private final Integer id;
    private final String name;
    private final double price;
    private int stock;

    public void reduceStock(int amount) throws NegativeStockException {
        if(amount > stock) {
            throw new NegativeStockException("You try to order more products - " + name + " than it is");
        }
        stock -= amount;
    }
}
