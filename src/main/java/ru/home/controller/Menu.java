package ru.home.controller;

import ru.home.service.impl.LibraryServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    private final BufferedReader READER;
    private final LibraryServiceImpl LIBRARY_SERVICE;
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
    private String bookControlPanel = """
            """;

    public Menu(){
        this.READER = new BufferedReader(new InputStreamReader(System.in));
        this.LIBRARY_SERVICE = new LibraryServiceImpl();
    }

    public void start(){
        mainMenu();
    }

    private void mainMenu() {
        System.out.println(mainMenu);
        switch (Integer.parseInt(readLine())) {
            case 1 -> userMenuPanel();
            case 0 -> {
                System.out.println("Program is terminating");
                try {
                    READER.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void userMenuPanel() {
        System.out.println(userControlPanel);
        System.out.println("Choose an option above: ");
        int input = Integer.parseInt(readLine());
        switch(input) {
            case 1 -> {
                System.out.println("Enter 4 digits user id(For example, 2001 or 4309): ");
                Long id = Long.parseLong(readLine());
                System.out.println("Enter user name: ");
                String name = readLine();
                System.out.println("Enter user email: ");
                String email = readLine();
                System.out.println("""
                                Choose user type: 
                                    1 - Guest
                                    2 - Student
                                    3 - Faculty
                                """);
                switch (Integer.parseInt(readLine())) {
                    case 1 -> {
                        LIBRARY_SERVICE.createUser(id,name,email,"guest");
                        LIBRARY_SERVICE.listAllUsers();
                    }
                    case 2 -> {
                        LIBRARY_SERVICE.createUser(id,name,email,"student");
                        LIBRARY_SERVICE.listAllUsers();
                    }
                    case 3 -> {
                        LIBRARY_SERVICE.createUser(id,name,email,"faculty");
                        LIBRARY_SERVICE.listAllUsers();
                    }
                }
            }
            case 2 -> {
                System.out.println("To delete user enter 4 digits userId(For example, 2001 or 4309): ");
                Long id = Long.parseLong(readLine());
                LIBRARY_SERVICE.removeUser(id);
            } case 3 -> {
                LIBRARY_SERVICE.listAllUsers();
            }
        }
    }

    private String readLine() {
        try {
            return READER.readLine().strip();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
