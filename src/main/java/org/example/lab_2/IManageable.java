package org.example.lab_2;

import java.util.List;

public interface IManageable {
    boolean add(Item item);
    boolean remove(Item item);
    List<Item> listAvailable();
    List<Item> listBorrowed();
}
