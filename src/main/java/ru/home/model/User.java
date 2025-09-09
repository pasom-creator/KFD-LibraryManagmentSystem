package ru.home.model;

import java.util.Objects;

public abstract class User {
    private Long userId;
    private String name;
    private String email;

    public User(Long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public abstract int getBooksLimit();

    public abstract int getBorrowDaysLimit();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(userId);
        result = 31 * result + Objects.hashCode(name);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
               "userId=" + userId +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}
