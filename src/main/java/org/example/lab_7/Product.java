package org.example.lab_7;

import lombok.*;

@Getter
@AllArgsConstructor
@ToString
public class Product {
    private final Integer id;
    private final String name;
    private final double price;
    private int stock;
}
