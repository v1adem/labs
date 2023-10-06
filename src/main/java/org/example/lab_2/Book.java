package org.example.lab_2;

import lombok.Setter;
import lombok.Getter;

@Getter @Setter
public class Book extends Item {
    private String author;

    public Book(String title, String author){
        super(title);
        this.author = author;
    }

    @Override
    public boolean borrowItem(){
        if (isBorrowed()) {
            return false;
        }
        setBorrowed(true);
        return true;
    }

    @Override
    public boolean returnItem(){
        if (!isBorrowed()) {
            return false;
        }
        setBorrowed(false);
        return true;
    }
}
