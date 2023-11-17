package org.example.lab_7;

import org.example.lab_7.exceptions.ItemNotFoundException;
import org.example.lab_7.exceptions.NegativeStockException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ECommercePlatformTest {
    static ECommercePlatform platform;
    static User[] users;
    static Product[] products;

    @BeforeAll
    static void globalConfig() throws InstanceAlreadyExistsException {

    }

    @BeforeEach
    void init() throws InstanceAlreadyExistsException {
        platform = new ECommercePlatform();
        platform.addUser("Test0");
        platform.addUser("Test1");
        platform.addUser("Test2");

        platform.addProduct("Prod0", 999, 1);
        platform.addProduct("Prod1", 99, 11);
        platform.addProduct("Prod2", 9999, 111);
    }

    @Test
    void getUserById_ShouldSuccessful() throws ItemNotFoundException {
        platform.addUser("Test3");
        assertEquals("Test3", platform.getUserById(3).getUsername());
    }

    @Test
    void getUserById_ShouldThrow() {
        assertThrows(ItemNotFoundException.class, () -> platform.getUserById(999));
        assertThrows(ItemNotFoundException.class, () -> platform.getUserById(-1));
    }

    @Test
    void getProductById_ShouldSuccessful() throws InstanceAlreadyExistsException, ItemNotFoundException {
        platform.addProduct("Prod3", 0, 0);
        assertEquals("Prod3", platform.getProductById(3).getName());
    }

    @Test
    void getProductById_ShouldThrow() {
        assertThrows(ItemNotFoundException.class, () -> platform.getProductById(999));
        assertThrows(ItemNotFoundException.class, () -> platform.getProductById(-1));
    }

    @Test
    void addProduct_ShouldThrow() {
        assertThrows(InstanceAlreadyExistsException.class, () -> platform.addProduct("Prod0", 0, 0));
    }

    @Test
    void makeOrder_ShouldSuccessful() throws ItemNotFoundException, NegativeStockException {
        User user = platform.getUserById(1);

        user.addToCart(platform.getProductById(1), 5);

        assertEquals(0, platform.getListOfOrders().size());

        platform.makeOrder(user.getId());

        assertEquals(1, platform.getListOfOrders().size());
        assertEquals(platform.getOrderById(0).getOrderDetails(), user.getHistory());
    }

    @Test
    void makeOrder_ShouldThrow() {
        assertThrows(ItemNotFoundException.class, () -> platform.makeOrder(9999));
        assertThrows(ItemNotFoundException.class, () -> platform.makeOrder(-1));
    }

    @Test
    void makeRecommendations_ShouldSuccessful() throws ItemNotFoundException, NegativeStockException {
        User user = platform.getUserById(2);
        user.addToCart(platform.getProductById(0), 1);
        user.addToCart(platform.getProductById(1), 5);
        user.addToCart(platform.getProductById(2), 3);

        platform.makeOrder(user.getId());

        List<Product> expected = Stream.of(platform.getProductById(1), platform.getProductById(2), platform.getProductById(0)).toList();
        assertEquals(expected, platform.makeRecommendations(user.getId()));
    }

    @Test
    void makeRecommendations_ShouldThrow() {
        assertThrows(ItemNotFoundException.class, () -> platform.makeRecommendations(9999));
        assertThrows(ItemNotFoundException.class, () -> platform.makeRecommendations(-1));
    }
}
