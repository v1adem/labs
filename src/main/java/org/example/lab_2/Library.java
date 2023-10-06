package org.example.lab_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library implements IManageable {
    private final List<Item> items;
    private final List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public boolean registerPatron(Patron patron) {
        if (patrons.contains(patron)){
            return false;
        }
        patrons.add(patron);
        return true;
    }

    public boolean lendItem(Patron patron, Item item){
        if (patrons.contains(patron) && items.contains(item) && !item.isBorrowed()){
            patron.borrowItem(item);
            return true;
        }
        return false;
    }

    public boolean returnItem(Patron patron, Item item){
        if (patrons.contains(patron)
                && items.contains(item)
                && patron.getBorrowedItems().contains(item)
                && item.isBorrowed()) {
            patron.returnItem(item);
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Item item) {
        if (items.contains(item)){
            return false;
        }
        items.add(item);
        return true;
    }

    @Override
    public boolean remove(Item item) {
        if (items.contains(item) && !item.isBorrowed()){
            items.remove(item);
            return true;
        }
        return false;
    }

    @Override
    public List<Item> listAvailable() {
        return items.stream().filter(item -> !item.isBorrowed()).collect(Collectors.toList());
    }

    @Override
    public List<Item> listBorrowed() {
        return items.stream().filter(Item::borrowItem).collect(Collectors.toList());
    }
}
