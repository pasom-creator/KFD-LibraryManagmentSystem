package ru.home.service;

import ru.home.model.Book;

public interface BookService {
    void addBook(Book book);

    void removeBook(String isbn);

    void sortAllBooksByTitle();

    void displayAllBookAuthors();

    void findBookByIsbn(String isbn);

    void findBookByAuthor(String author);

    void findBookByTitle(String title);
}
