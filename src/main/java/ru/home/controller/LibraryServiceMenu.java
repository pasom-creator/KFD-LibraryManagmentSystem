package ru.home.controller;

import ru.home.service.impl.LibraryServiceImpl;
import ru.home.util.ConsoleReader;

public class LibraryServiceMenu extends GeneralMenu {
    private final LibraryServiceImpl LIBRARY_SERVICE;
    private static final String LIBRARY_MENU = """
            
            1 - Register user in library(Create new library card)
            2 - Delete library card
            3 - Display all library cards
            4 - Borrow book
            5 - Return book
            6 - Display all borrowed books
            7 - Find Overdue books
            0 - Back to previous menu
            """;

    public LibraryServiceMenu(MainMenu menu, LibraryServiceImpl libraryService) {
        super(LIBRARY_MENU);
        this.LIBRARY_SERVICE = libraryService;
        GENERAL_MAP.put("1", this::addLibraryCard);
        GENERAL_MAP.put("2", this::deleteLibraryCard);
        GENERAL_MAP.put("3", this::displayAllLibraryCards);
        GENERAL_MAP.put("4", this::borrowBook);
        GENERAL_MAP.put("5", this::returnBook);
        GENERAL_MAP.put("6", this::displayAllBorrowedBooks);
        GENERAL_MAP.put("7", this::findOverdueBooks);
        GENERAL_MAP.put("0", menu::mainMenu);
    }

    private void addLibraryCard() {

    }

    private void deleteLibraryCard() {
        Long libraryCardId = getLibraryCardId();
        LIBRARY_SERVICE.removeLibraryCard(libraryCardId);
    }

    private void displayAllLibraryCards() {
        LIBRARY_SERVICE.displayAllLibraryCards();
    }

    private void borrowBook() {
        String isbn = getIsbn();
        Long libraryCardId = getLibraryCardId();
        System.out.println(LIBRARY_SERVICE.borrowBook(isbn,libraryCardId));
    }

    private void returnBook() {
        String isbn = getIsbn();
        Long libraryCardId = getLibraryCardId();
        System.out.println(LIBRARY_SERVICE.returnBook(isbn,libraryCardId));
    }

    private void displayAllBorrowedBooks() {
        LIBRARY_SERVICE.displayAllBorrowedBooks();
    }

    private void findOverdueBooks() {
        LIBRARY_SERVICE.findOverdueBooks();
    }

    private static String getIsbn() {
        return ConsoleReader.askQuestion("Enter book ISBN: ");
    }

    private static Long getLibraryCardId() {
        Long libraryCardId = null;
        try {
            libraryCardId = Long.parseLong(ConsoleReader.askQuestion("Enter library card ID: "));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Wrong input, only digits allowed");
        }
        return libraryCardId;
    }
}
