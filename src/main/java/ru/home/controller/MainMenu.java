package ru.home.controller;

public class MainMenu extends GeneralMenu{
    private static final String MAIN_MENU = """
            1 - User Control Panel
            2 - Book Control Panel
            3 - Library Service
            0 - Exit program
            
            For navigating through menu
            enter digit from 0 to 3: 
            """;
    private String userControlPanel = """
            1 - Add User
            2 - Remove User
            3 - Display all Users
            
            """;

    {

    }

    public MainMenu(){
        super(MAIN_MENU);
        GENERAL_MAP.put("1", this::userMenuPanel);
        GENERAL_MAP.put("2", this::bookControlMenu);
        GENERAL_MAP.put("3", this::libraryServiceMenu);
        GENERAL_MAP.put("0", ()->{
            System.out.println("Program terminated");
            System.exit(0);
        });
    }

    public void mainMenu() {
        start(); // execute number 1 and value
    }

    private void userMenuPanel() {
        new UserControlMenu(this).start();
    }

    private void bookControlMenu() {
        new BookControlMenu(this).start();
    }

    private void libraryServiceMenu() {
        System.out.println("Test");
    }


}
