package ru.home.repository;

import ru.home.model.Faculty;
import ru.home.model.Guest;
import ru.home.model.Student;
import ru.home.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private final Map<Long, User> USER_LIST;

    public UserRepository() {
        this.USER_LIST = new HashMap<>();
    }

    public User createUser(Long id, String name, String email, String type) {
        if (type.equalsIgnoreCase("faculty")) {
            return new Faculty(id, name, email);
        } else if (type.equalsIgnoreCase("student")) {
            return new Student(id, name, email);
        }
        return new Guest(id, name, email);
    }

    public void addUser(User user) {
        if (!USER_LIST.containsKey(user.getUserId())) {
            USER_LIST.put(user.getUserId(), user);
        } else {
            throw new IllegalArgumentException("User id %d is already exist".formatted(user.getUserId()));
        }
    }

    public void removeUser(Long userId) {
        if (!USER_LIST.isEmpty() && USER_LIST.containsKey(userId)) {
            USER_LIST.remove(userId);
            System.out.printf("User id %d is successfully deleted\n", userId);
        } else {
            System.out.printf("User id %d doesn't find in database\n", userId);
        }
    }

    public List<User> listUsers() {
        return new ArrayList<>(USER_LIST.values());
    }
}
