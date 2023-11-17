package org.example.lab_7;

import lombok.*;
import org.example.lab_7.exceptions.NegativeStockException;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class Product implements Comparable<Product> {
    private final Integer id;
    private final String name;
    private final double price;
    @Setter
    private int stock;

    public void reduceStock(int amount) throws NegativeStockException {
        if(amount > stock) {
            throw new NegativeStockException("You try to order more products - " + name + " than it is");
        }
        stock -= amount;
    }

    @Override
    public int compareTo(@NotNull Product o) {
        return Double.compare(price, o.price);
    }

    @Override
    public String toString() {
        return "Product - " + name + " | id - " + id + " | Price - " + price + " | Stock - " + stock + " ";
    }
}
