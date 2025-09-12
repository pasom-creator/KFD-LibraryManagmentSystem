package ru.home.controller;

import ru.home.service.impl.LibraryServiceImpl;

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

    }

    private void displayAllLibraryCards() {
        LIBRARY_SERVICE.displayAllLibraryCards();
    }

    private void borrowBook() {

    }

    private void returnBook() {

    }

    private void displayAllBorrowedBooks() {
        LIBRARY_SERVICE.displayAllBorrowedBooks();
    }

    private void findOverdueBooks() {
        LIBRARY_SERVICE.findOverdueBooks();
    }
}
