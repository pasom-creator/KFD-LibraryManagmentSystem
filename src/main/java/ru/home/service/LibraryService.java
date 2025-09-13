package ru.home.service;

public interface LibraryService {
    void createLibraryCard(Long libraryCardId, Long userId);

    void removeLibraryCard(Long cardId);

    void displayAllLibraryCards();

    void borrowBook(String isbn, Long cardId);

    boolean returnBook(String isbn, Long cardId);

    void displayAllBorrowedBooks();

    void findOverdueBooks();
}
