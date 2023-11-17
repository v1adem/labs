package org.example.lab_7;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public class User {
    private final Integer id;
    private final String username;
    private Map<Product, Integer> cart;
    private final Map<Product, Integer> history;

    public User(int id, @NonNull String username){
        this.id = id;
        this.username = username;
        cart = new HashMap<>();
        history = new HashMap<>();
    }

    public void addToCart(@NonNull Product product, @NonNull Integer amount){
        cart.put(product, amount);
    }

    public Optional<Product> removeFromCart(@NonNull Product product){
        if(cart.containsKey(product)){
            return Optional.of(product);
        }
        return Optional.empty();
    }

    public void modifyCart(@NonNull Product product, @NonNull Integer amount){
        cart.merge(product, amount, Integer::sum);
    }

    public void clearCart(){
        cart = new HashMap<>();
    }

    public void updateHistory(@NonNull Order order){
        order.getOrderDetails().forEach((product, amount) -> history.merge(product, amount, Integer::sum));
    }

    @Override
    public String toString() {
        return "User - " + username + " | id - " + id + "\n\tCart " + cart + "\n\tHistory " + history;
    }
}
