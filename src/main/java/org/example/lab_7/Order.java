package org.example.lab_7;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public class Order {
    private final Integer id;
    private final Integer userId;
    private final Map<Product, Integer> orderDetails;
    private double totalPrice;

    public Order(int id, int userId, @NonNull Map<Product, Integer> orderDetails){
        this.id = id;
        this.userId = userId;
        this.orderDetails = orderDetails;
        calculateTotalPrice();
    }

    private void calculateTotalPrice(){
        for (Product product : orderDetails.keySet())
        {
            totalPrice += product.getPrice() * orderDetails.get(product);
        }
    }
}
