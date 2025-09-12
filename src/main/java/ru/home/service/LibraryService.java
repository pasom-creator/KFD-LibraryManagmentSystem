package ru.home.service;

import ru.home.model.LibraryCard;

public interface LibraryService {
    void addLibraryCard(LibraryCard libraryCard);

    void removeLibraryCard(Long cardId);

    void displayAllLibraryCards();

    boolean borrowBook(String isbn, Long cardId);

    boolean returnBook(String isbn, Long cardId);

    void displayAllBorrowedBooks();

    void findOverdueBooks();
}
