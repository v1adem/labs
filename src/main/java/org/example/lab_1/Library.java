package org.example.lab_1;

import java.util.ArrayList;
import java.util.Optional;

public class Library {
    private final ArrayList<Book> library;

    public Library() {
        library = new ArrayList<>();
    }

    public boolean add(Book book) {
        return library.add(book);
    }

    public Optional<Book> findByName(String name){
        for (Book book : library) {
            if (book.getName().equals(name)){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    public Optional<Book> removeByISBN(Long isbn){
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getIsbn().equals(isbn)){
                return Optional.of(library.remove(i));
            }
        }
        return Optional.empty();
    }

    public void printBooks() {
        for (Book book : library){
            System.out.println(book);
        }
    }
}
