package ru.home.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

import static ru.home.controller.ConsoleReader.askQuestion;

public class AdvancedMenu {
    private final BufferedReader READER;
    private Map<String,Runnable> methodMap;
    private String mainMenu = """
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
        methodMap.put("1", this::userMenuPanel);
        methodMap.put("2", this::bookControlMenu);
        methodMap.put("3", this::libraryServiceMenu);
    }

    public AdvancedMenu(){
        this.READER = new BufferedReader(new InputStreamReader(System.in));
    }

    public void mainMenu() {
        String answer = askQuestion(mainMenu);
        methodMap.get(answer).run(); // execute number 1 and value
    }

    private void userMenuPanel() {
        new UserMenuPanel(this).start();
    }

    private void bookControlMenu() {

    }

    private void libraryServiceMenu() {

    }


}
