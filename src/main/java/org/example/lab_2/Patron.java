package org.example.lab_2;

import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class Patron {
    private String name;
    private String ID;
    private List<Item> borrowedItems;

    public Patron(String name){
        this.name = name;
        ID = UUID.randomUUID().toString();
        borrowedItems = new ArrayList<>();
    }

    public void borrowItem(Item item) {
        item.borrowItem();
        borrowedItems.add(item);
    }

    public void returnItem(Item item) {
        item.returnItem();
        borrowedItems.remove(item);
    }
}
