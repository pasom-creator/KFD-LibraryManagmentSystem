package ru.home.repository;

import ru.home.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookRepository {
    private final Map<String, Book> LIBRARY_STORAGE;

    public BookRepository() {
        this.LIBRARY_STORAGE = new HashMap<>();
    }

    public void addBook(Book book) {
        if (!LIBRARY_STORAGE.containsKey(book.getIsbn())) {
            LIBRARY_STORAGE.put(book.getIsbn(), book);
        } else {
            throw new IllegalArgumentException("Book with ISBN %s is already exist".formatted(book.getIsbn()));
        }
    }

    public void removeBook(String isbn) {
        if (!LIBRARY_STORAGE.isEmpty() && LIBRARY_STORAGE.containsKey(isbn)) {
            LIBRARY_STORAGE.remove(isbn);
            System.out.printf("Book with ISBN %s is successfully deleted\n", isbn);
        } else {
            System.out.printf("Book with ISBN %s doesn't find in database\n", isbn);
        }
    }

    public boolean isBookAvailable(String isbn) {
        return LIBRARY_STORAGE.containsKey(isbn) && LIBRARY_STORAGE.get(isbn).isAvailable();
    }

    public void changeBookStatus(String isbn) {
        LIBRARY_STORAGE.get(isbn).setAvailable(!LIBRARY_STORAGE.get(isbn).isAvailable());
    }

    public List<Book> listAllBooks() {
        return new ArrayList<>(LIBRARY_STORAGE.values());
    }

    public Set<String> listAllAuthors() {
        Set<String> authorsList = new HashSet<>();
        for (Map.Entry<String, Book> bookEntry : LIBRARY_STORAGE.entrySet()) {
            authorsList.add(bookEntry.getValue().getAuthor());
        }
        return authorsList;
    }

    public Book findBookByIsbn(String isbn) {
        return LIBRARY_STORAGE.get(isbn);
    }

    public List<Book> findBookByAuthor(String author) {
        List<Book> bookByAuthor = new ArrayList<>();
        for (Map.Entry<String, Book> bookEntry : LIBRARY_STORAGE.entrySet()) {
            if (bookEntry.getValue().getAuthor().equalsIgnoreCase(author)) {
                bookByAuthor.add(bookEntry.getValue());
            }
        }
        return bookByAuthor;
    }

    public Book findBookByTitle(String title) {
        for (Book value : LIBRARY_STORAGE.values()) {
            if (value.getTitle().equalsIgnoreCase(title)) {
                return value;
            }
        }
        return null;
    }
}
