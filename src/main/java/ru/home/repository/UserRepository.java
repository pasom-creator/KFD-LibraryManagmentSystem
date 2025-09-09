package ru.home.repository;

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

    public void addUser(User user) {
        if (!USER_LIST.containsKey(user.getUserId())) {
            USER_LIST.put(user.getUserId(), user);
        }
    }

    public void removeUser(Long userId) {
        if (!USER_LIST.isEmpty()) {
            USER_LIST.remove(userId);
        }
    }

    public List<User> listUsers() {
        return new ArrayList<>(USER_LIST.values());
    }
}
