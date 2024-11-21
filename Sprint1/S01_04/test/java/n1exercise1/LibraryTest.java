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
    }

    @Test
    public void testListIsNotNull() {
        assertNotNull(library.getBooksList(), "The books list should not be null.");
    }

    @Test
    public void testAddBooks() {
        library.addBook("Book 1");
        library.addBook("Book 2");
        List<String> books = library.getBooksList();
        assertEquals(2, books.size(), "The list should contain 2 books.");
    }

    @Test
    public void testAddBookAtPosition() {
        library.addBook("Book 1");
        library.addBookAtPosition("Book 2",0 );
        List<String> books = library.getBooksList();
        assertEquals("Book 2", books.get(0), "The first book should be 'Book 2'.");
    }

    @Test
    public void testRemoveBookByTitle() {
        library.addBook("Book 1");
        boolean removed = library.removeBookByTitle("Book 1");
        assertTrue(removed, "The book should be removed.");
        assertEquals(0, library.getBooksList().size(), "The list should contain 0 books after removal.");
    }

    @Test
    public void testListSorted() {
        library.addBook("Book A");
        library.addBook("Book B");
        library.addBook("Book C");
        List<String> books = library.getBooksList();
        assertEquals("Book A", books.get(0), "The first book should be 'Book A'.");
        assertEquals("Book B", books.get(1), "The second book should be 'Book B'.");
        assertEquals("Book C", books.get(2), "The third book should be 'Book C'.");
    }

    @Test
    public void testGetBookByPosition() {
        library.addBook("Book 1");
        library.addBook("Book 2");
        String book = library.getBookByPosition(1);
        assertEquals("Book 2", book, "The book at position 1 should be 'Book 2'.");
    }

    @Test
    public void testNoDuplicates() {
        library.addBook("Book 1");
        library.addBook("Book 2");
        List<String> books = library.getBooksList();
        assertEquals(2, books.size(), "There should be no duplicate books in the list.");
    }
}