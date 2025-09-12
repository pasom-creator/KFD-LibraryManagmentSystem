package ru.home.controller;

import ru.home.service.impl.LibraryServiceImpl;

import java.util.Map;

import static ru.home.util.ConsoleReader.askQuestion;

public class UserControlMenu extends GeneralMenu {
    private static final String USER_CONTROL_PANEL = """
            
            1 - Add User
            2 - Remove User
            3 - Display all Users
            0 - Back to previous menu
            """;
    private final LibraryServiceImpl LIBRARY_SERVICE;

    public UserControlMenu(MainMenu menu, LibraryServiceImpl libraryService) {
        super(USER_CONTROL_PANEL);
        this.LIBRARY_SERVICE = libraryService;
        GENERAL_MAP.put("1", this::addUser);
        GENERAL_MAP.put("2", this::removeUser);
        GENERAL_MAP.put("3", this::displayAllUsers);
        GENERAL_MAP.put("0", menu::mainMenu);
    }

    public void addUser() {
        long id = 0;
        try {
            id = Long.parseLong(askQuestion("""
                    You are going to create and add user.
                    Enter 4 digits user id(For example, 2001 or 4309): """));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Wrong input");
        }
        String name = askQuestion("Enter user name: ");
        String email = askQuestion("Enter user email: ");
        builderUser(id,name,email);
    }

    public void removeUser() {
        Long id = null;

        try {
            id = Long.parseLong(askQuestion("You are going to delete user. Enter 4 digits user id: "));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Wrong input");
        }

        LIBRARY_SERVICE.removeUser(id);
    }

    public void displayAllUsers() {
        LIBRARY_SERVICE.listAllUsers();
    }

    private void builderUser(Long id,String name,String email) {
        String USER_TYPE_MENU = """
                Choose user type: 
                    1 - Guest
                    2 - Student
                    3 - Faculty
                """;
        Map<Integer,String> userType = Map.of(
                1,"guest",
                2, "student",
                3, "faculty");
        int userTypeId = 0;

        try {
            userTypeId = Integer.parseInt(askQuestion(USER_TYPE_MENU));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Wrong input");
        }

        LIBRARY_SERVICE.createUser(id, name, email, userType.get(userTypeId));
    }
}