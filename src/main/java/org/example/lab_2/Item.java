package org.example.lab_2;

import lombok.Setter;
import lombok.Getter;

import java.util.UUID;

@Getter @Setter
public abstract class Item {
    private String uniqueID;
    private String title;
    private boolean isBorrowed = false;

    public Item(String title){
        this.title = title;
        this.uniqueID = UUID.randomUUID().toString();
    }

    abstract boolean borrowItem();
    abstract boolean returnItem();

}
