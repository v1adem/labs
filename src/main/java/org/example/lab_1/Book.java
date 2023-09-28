package org.example.lab_1;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@AllArgsConstructor @Getter @Setter
public class Book {
    private Long isbn;
    private String name;
    private String author;
    private int year;

    @Override
    public String toString() {
        return String.format("%s, %s [%d] - ISBN:%d", name, author, year, isbn);
    }
}
