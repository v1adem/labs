package lab_1;

import org.example.lab_1.Book;
import org.example.lab_1.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book book;

    @BeforeEach
    public void init() {
        library = new Library();
        book = new Book(9786171232396L, "Дюна", "Френк Герберт", 1965);
    }

    @Test
    public void testAddMethod() {
        assertTrue(library.add(book));
    }

    @Test
    public void testRemoveMethod() {
        library.add(book);
        assertEquals(Optional.of(book), library.removeByISBN(book.getIsbn()));
        assertFalse(library.removeByISBN(1L).isPresent());
    }

    @Test
    public void testFindMethod() {
        library.add(book);
        assertEquals(Optional.of(book), library.findByName(book.getName()));
        assertFalse(library.findByName("NotExist").isPresent());
    }
}
