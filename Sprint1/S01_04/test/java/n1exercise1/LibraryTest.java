package n1exercise1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();

        library.addBook("Book 1");
        library.addBook("Book 2");
    }

    @Test
    public void testListIsNotNull() {
        assertNotNull(library.getBooksList(), "The books list should not be null.");
    }

    @Test
    public void testAddBooks() {
        library.addBook("Book 3");

        List<String> books = library.getBooksList();

        assertEquals(3, books.size(), "The list should contain 3 books.");
    }

    @Test
    public void testAddBookAtPosition() {
        library.addBookAtPosition("Book 3", 0);

        List<String> books = library.getBooksList();

        assertEquals("Book 3", books.get(0), "The first book should be 'Book 3'.");
    }

    @Test
    public void testRemoveBookByTitle() {
        boolean removed = library.removeBookByTitle("Book 1");

        assertTrue(removed, "The book should be removed.");
        assertEquals(1, library.getBooksList().size(), "The list should contain 1 book after removal.");
    }

    @Test
    public void testListSorted() {
        List<String> books = library.getBooksList();

        assertEquals("Book 1", books.get(0), "The first book should be 'Book 1'.");
        assertEquals("Book 2", books.get(1), "The second book should be 'Book 2'.");
    }

    @Test
    public void testGetBookByPosition() {
        String book = library.getBookByPosition(1);

        assertEquals("Book 2", book, "The book at position 1 should be 'Book 2'.");
    }

    @Test
    public void testNoDuplicates() {
        library.addBook("Book 3");

        List<String> books = library.getBooksList();

        assertEquals(3, books.size(), "There should be no duplicate books in the list.");
    }
}