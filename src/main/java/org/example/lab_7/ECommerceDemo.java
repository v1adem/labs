package org.example.lab_7;

import org.example.lab_7.exceptions.ItemNotFoundException;
import org.example.lab_7.exceptions.NegativeStockException;

import javax.management.InstanceAlreadyExistsException;

public class ECommerceDemo {
    public static final ECommercePlatform platform = new ECommercePlatform();

    public static void main(String[] args) throws InstanceAlreadyExistsException, ItemNotFoundException, NegativeStockException {
        platform.addUser("Fred");
        platform.addUser("Bred");
        platform.addUser("Dread");

        platform.addProduct("Guitar", 11999.99,5);
        platform.addProduct("Drum", 19999.99,3);
        platform.addProduct("Violin", 29999.99,12);


        User user = platform.getUserById(1);

        user.addToCart(platform.getProductById(0), 1);
        user.addToCart(platform.getProductById(2), 2);
        user.modifyCart(platform.getProductById(2), 3);
        platform.makeOrder(user.getId());

        user.addToCart(platform.makeRecommendations(user.getId()).get(0), 7);
        platform.makeOrder(user.getId());

        System.out.println("\nList of users:");
        platform.getListOfUsers().forEach(System.out::println);

        System.out.println("\nList of products:");
        platform.getListOfProducts().forEach(System.out::println);

        System.out.println("\nList of orders:");
        platform.getListOfOrders().forEach(System.out::println);

        System.out.println("\n\t*** Sorted Products ***");
        printProductsSorted_ByName();
        printProductsSorted_ByPrice();
        printProductsSorted_ByStock();
    }


    public static void printProductsSorted_ByName(){
        System.out.println("\n\t1) By name:");
        platform.getListOfProducts()
                .stream()
                .sorted(new ProductNameComparator())
                .forEach(System.out::println);
    }

    public static void printProductsSorted_ByPrice(){
        System.out.println("\n\t2) By price:");
        platform.getListOfProducts()
                .stream()
                .sorted()
                .forEach(System.out::println);
    }

    public static void printProductsSorted_ByStock(){
        System.out.println("\n\t3) By stock:");
        platform.getListOfProducts()
                .stream()
                .sorted(new ProductStockComparator())
                .forEach(System.out::println);
    }
}
