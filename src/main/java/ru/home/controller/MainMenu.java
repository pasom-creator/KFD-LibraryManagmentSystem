package ru.home.controller;

import ru.home.service.impl.LibraryServiceImpl;

public class MainMenu extends GeneralMenu {
    private final LibraryServiceImpl LIBRARY_SERVICE = new LibraryServiceImpl();
    private static final String MAIN_MENU = """
            1 - User Control Panel
            2 - Book Control Panel
            3 - Library Service
            0 - Exit program
            
            For navigating through menu
            enter digit from 0 to 3: 
            """;

    public MainMenu() {
        super(MAIN_MENU);
        GENERAL_MAP.put("1", this::userMenuPanel);
        GENERAL_MAP.put("2", this::bookControlMenu);
        GENERAL_MAP.put("3", this::libraryServiceMenu);
        GENERAL_MAP.put("0", () -> {
            System.out.println("Program terminated");
            System.exit(0);
        });
    }

    public void mainMenu() {
        start();
    }

    private void userMenuPanel() {
        new UserControlMenu(this, LIBRARY_SERVICE).start();
    }

    private void bookControlMenu() {
        new BookControlMenu(this, LIBRARY_SERVICE).start();
    }

    private void libraryServiceMenu() {
        new LibraryServiceMenu(this,LIBRARY_SERVICE).start();
    }

}
