package n1exercise1;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<String> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String book) {
        books.add(book);
    }

    public String getBookByPosition(int position) {
        if (position >= 0 && position < books.size()) {
            return books.get(position);
        }
        return null;
    }

    public List<String> getBooksList() {
        return books;
    }

    public boolean removeBookByTitle(String book) {
        return books.remove(book);
    }

    public void addBookAtPosition(String book, int position) {
        books.add(position, book);
    }
}