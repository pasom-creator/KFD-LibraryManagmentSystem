package ru.home.controller;


public class BookControlMenu extends GeneralMenu{
    private static final String BOOK_CONTROL_PANEL = """
            1 - Add book
            2 - Remove book
            3 - List all books(Sorted by Title)
            0 - Return to Main menu
            
            """;

    public BookControlMenu(MainMenu menu) {
        super(BOOK_CONTROL_PANEL);
        GENERAL_MAP.put("1", this::addBook);
        GENERAL_MAP.put("2", this::removeBook);
        GENERAL_MAP.put("3", this::ListAllBooks);
        GENERAL_MAP.put("0", menu::mainMenu);
    }

    private void ListAllBooks() {
//        LIBRARY_SERVICE.listAllUsers();
        System.out.println("Test");
    }

    private void removeBook() {

    }

    private void addBook() {

    }


}
