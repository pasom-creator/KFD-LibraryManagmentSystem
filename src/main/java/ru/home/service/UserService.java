package ru.home.service;

public interface UserService {
    void createUser(Long id, String name, String email, String type);

    void removeUser(Long userId);

    void listAllUsers();
}
