package ru.home.service;

import ru.home.model.BorrowedBook;

import java.util.List;

public interface LibraryService {
    boolean borrowBook(String isbn, Long cardId);

    boolean returnBook(String isbn, Long cardId);

    void findOverdueBooks();

    void sortAllBooksByTitle();

    void displayAllAuthors();

    void displayAllBorrowedBooks();

    void displayAllLibraryCards();
}
