package org.example.lab_1;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.add(new Book(9786171232396L, "Дюна", "Френк Герберт", 1965));

        library.printBooks();
    }
}
