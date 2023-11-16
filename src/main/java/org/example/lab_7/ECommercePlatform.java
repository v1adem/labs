package org.example.lab_7;

import lombok.NonNull;
import org.example.lab_7.exceptions.ItemNotFoundException;
import org.example.lab_7.exceptions.NegativeStockException;

import javax.management.InstanceAlreadyExistsException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ECommercePlatform {
    private final Map<Integer, User> users = new HashMap<>();
    private final Map<Integer, Product> products = new HashMap<>();
    private final Map<Integer, Order> orders = new HashMap<>();

    public User getUserById(int id) throws ItemNotFoundException {
        if (users.containsKey(id)) {
            return users.get(id);
        }
        throw new ItemNotFoundException("User not found | id: " + id);
    }

    public Product getProductById(int id) throws ItemNotFoundException {
        if (products.containsKey(id)) {
            return products.get(id);
        }
        throw new ItemNotFoundException("Product not found | id: " + id);
    }

    public Order getOrderById(int id) throws ItemNotFoundException {
        if (orders.containsKey(id)) {
            return orders.get(id);
        }
        throw new ItemNotFoundException("Order not found | id: " + id);
    }

    public Product addProduct(@NonNull String name, double price, int stock) throws InstanceAlreadyExistsException {
        for (int productId : products.keySet()) {
            if (products.get(productId).getName().equals(name)) {
                throw new InstanceAlreadyExistsException("You try to create the same Product: " + name);
            }
        }
        Product product = new Product(products.size(), name, price, stock);
        products.put(products.size(), product);
        return product;
    }

    public User addUser(@NonNull String username) {
        User user = new User(users.size(), username);
        users.put(users.size(), user);
        return user;
    }

    public Order makeOrder(int userId) throws ItemNotFoundException {
        User user = getUserById(userId);
        Order order = new Order(orders.size(), user.getId(), user.getCart());

        user.clearCart();
        user.updateHistory(order);

        order.getOrderDetails().forEach((product, amount) -> {
            try {
                product.reduceStock(amount);
            } catch (NegativeStockException e) {
                throw new RuntimeException(e);
            }
        });
        return orders.put(order.getId(), order);
    }

    public List<User> getListOfUsers() {
        return users.values().stream().toList();
    }

    public List<Product> getListOfProducts() {
        return products.values().stream().toList();
    }

    public List<Product> getListOfAvailableProducts() {
        return products.values().stream().filter(product -> product.getStock() > 0).toList();
    }

    public List<Order> getListOfOrders() {
        return orders.values().stream().toList();
    }
}
