package org.example.lab_7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Product {
    private final Integer id;
    private final String name;
    private double price;
    private int stock;
}
