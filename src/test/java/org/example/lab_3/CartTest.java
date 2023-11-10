package org.example.lab_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {
    @Mock
    private Product product1;
    @Mock
    private Product product2;
    @Mock
    private Product product3;
    private Cart cart;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cart = new Cart();

        cart.add(product1);
        cart.add(product2);
    }

    @Test
    void testAddProductToCart() {
        assertTrue(cart.add(product1).isEmpty());
        assertTrue(cart.add(product3).isPresent());
    }

    @Test
    void testRemoveProductFromCart() {
        assertTrue(cart.remove(product3).isEmpty());
        assertTrue(cart.remove(product1).isPresent());
    }

    @Test
    void testMakeOrder() {
        Order order = cart.order();

        assertEquals(2, order.getProducts().size());
    }

    @Test
    void testOrderShipped() {
        Order order = cart.order();

        assertEquals(Status.Pending, order.getStatus());

        order.setStatusShipped();

        assertEquals(Status.Shipped, order.getStatus());
    }
}