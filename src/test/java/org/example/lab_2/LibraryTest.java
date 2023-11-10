package org.example.lab_2;

import org.example.lab_2.Book;
import org.example.lab_2.Library;
import org.example.lab_2.Patron;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book book;
    private Patron patron1;
    private Patron patron2;

    @BeforeEach
    public void init() {
        library = new Library();
        book = new Book("Book", "Author");
        patron1 = new Patron("Patron1");
        patron2 = new Patron("Patron2");
    }

    @Test
    public void testRegisterPatron() {
        assertTrue(library.registerPatron(patron1));
        assertFalse(library.registerPatron(patron1));
    }

    @Test
    public void testLendItem() {
        assertFalse(library.lendItem(patron1, book));

        library.registerPatron(patron1);
        library.registerPatron(patron2);
        library.add(book);

        assertTrue(library.lendItem(patron1, book));
        assertFalse(library.lendItem(patron2, book));
    }

    @Test
    public void testReturnItem() {
        assertFalse(library.returnItem(patron1, book));

        library.registerPatron(patron1);
        library.registerPatron(patron2);
        library.add(book);

        assertFalse(library.returnItem(patron1, book));

        library.lendItem(patron1, book);

        assertFalse(library.returnItem(patron2, book));
        assertTrue(library.returnItem(patron1, book));
    }
}