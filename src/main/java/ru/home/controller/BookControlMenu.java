package ru.home.controller;

import ru.home.model.Book;
import ru.home.service.impl.LibraryServiceImpl;
import ru.home.util.ConsoleReader;

public class BookControlMenu extends GeneralMenu {
    private static final String BOOK_CONTROL_PANEL = """
            
            1 - Add book
            2 - Remove book
            3 - List all books(Sorted by Title)
            4 - List all authors in library
            5 - Find book by ISBN
            6 - Find books by author
            7 - Find book by title
            0 - Return to Main menu
            """;
    private final LibraryServiceImpl LIBRARY_SERVICE;

    public BookControlMenu(MainMenu menu, LibraryServiceImpl libraryService) {
        super(BOOK_CONTROL_PANEL);
        this.LIBRARY_SERVICE = libraryService;
        GENERAL_MAP.put("1", this::addBook);
        GENERAL_MAP.put("2", this::removeBook);
        GENERAL_MAP.put("3", this::ListAllBooksSortedByTitle);
        GENERAL_MAP.put("4", this::displayAllBookAuthors);
        GENERAL_MAP.put("5", this::findBookByIsbn);
        GENERAL_MAP.put("6", this::findBookByAuthor);
        GENERAL_MAP.put("7", this::findBookByTitle);
        GENERAL_MAP.put("0", menu::mainMenu);
    }

    private void addBook() {
        String isbn = ConsoleReader.askQuestion("""
                You are going to add book to library.
                Enter ISBN (Any format: 8903-928392-IOMD-940): 
                """);
        String title = ConsoleReader.askQuestion("Enter book title: ");
        String author = ConsoleReader.askQuestion("Enter book author: ");
        LIBRARY_SERVICE.addBook(new Book(isbn, title, author, true));
    }

    private void removeBook() {
        LIBRARY_SERVICE.removeBook(ConsoleReader.askQuestion("You are going to delete book. Enter isbn: "));
    }

    private void ListAllBooksSortedByTitle() {
        LIBRARY_SERVICE.sortAllBooksByTitle();
    }

    private void displayAllBookAuthors() {
        LIBRARY_SERVICE.displayAllBookAuthors();
    }

    private void findBookByIsbn() {
        LIBRARY_SERVICE.findBookByIsbn(
                ConsoleReader.askQuestion("Search book by ISBN. Enter isbn: "));
    }

    private void findBookByAuthor() {
        LIBRARY_SERVICE.findBookByAuthor(
                ConsoleReader.askQuestion("Search books by author. Enter author: "));
    }

    private void findBookByTitle() {
        LIBRARY_SERVICE.findBookByTitle(
                ConsoleReader.askQuestion("Search book by title. Enter title: "));
    }
}
