package org.example.lab_7;

import lombok.NonNull;

import java.util.Comparator;

public class ProductStockComparator implements Comparator<Product> {
    @Override
    public int compare(@NonNull Product o1, @NonNull Product o2) {
        return Integer.compare(o1.getStock(), o2.getStock());
    }
}