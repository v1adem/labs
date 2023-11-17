package org.example.lab_7;

import lombok.NonNull;

import java.util.Comparator;

public class ProductNameComparator implements Comparator<Product> {
    @Override
    public int compare(@NonNull Product o1, @NonNull Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
