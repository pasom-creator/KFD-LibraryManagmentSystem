package ru.home.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryCard implements Comparable<LibraryCard> {
    private Long id;
    private User user;
    final private List<BorrowedBook> borrowedBooks;

    public LibraryCard(Long id, User user) {
        this.borrowedBooks = new ArrayList<>();
        this.id = id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<BorrowedBook> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public int compareTo(LibraryCard o) {
        return Long.compare(id, o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        LibraryCard that = (LibraryCard) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(user);
        return result;
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
               "id=" + id +
               ", user=" + user +
               ", borrowedBooks=" + borrowedBooks +
               '}';
    }
}
