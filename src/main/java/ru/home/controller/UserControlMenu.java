package ru.home.controller;

import java.util.Map;

import static ru.home.controller.ConsoleReader.askQuestion;

public class UserControlMenu extends GeneralMenu {
    private final String USER_TYPE_MENU = """
                Choose user type: 
                    1 - Guest
                    2 - Student
                    3 - Faculty
                """;
    private static final String USER_CONTROL_PANEL = """
            1 - Add User
            2 - Remove User
            3 - Display all Users
            0 - Back to previous menu
            """;

    public UserControlMenu(MainMenu menu) {
        super(USER_CONTROL_PANEL);
        GENERAL_MAP.put("1", this::addUser);
        GENERAL_MAP.put("2", this::removeUser);
        GENERAL_MAP.put("3", this::displayAllUsers);
        GENERAL_MAP.put("0", menu::mainMenu);
    }

    public void addUser() {
        Long id = null;
        try {
            id = Long.parseLong(askQuestion("Enter 4 digits user id(For example, 2001 or 4309): "));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Wrong input");
        }
        String name = askQuestion("Enter user name: ");
        String email = askQuestion("Enter user email: ");
        builderUser(id,name,email);
    }

    public void removeUser() {
        System.out.println("Test");
    }

    public void displayAllUsers() {
        System.out.println("Test");
    }

    private void builderUser(Long id,String name,String email) {
        Map<Integer,String> userType = Map.of(
                1,"guest",
                2, "student",
                3, "faculty");

        int userTypeId = Integer.parseInt(askQuestion(USER_TYPE_MENU));
//        LIBRARY_SERVICE.createUser(id, name, email, userTypeId);
    }
}
