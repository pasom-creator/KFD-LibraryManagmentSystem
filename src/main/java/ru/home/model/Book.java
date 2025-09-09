package ru.home.model;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private String isbn;
    private String title;
    private String author;
    private boolean available;

    public Book(String isbn) {
        this.isbn = isbn;
    }

    public Book(String isbn, String title, String author, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public int compareTo(Book o) {
        try {
            return this.title.compareTo(o.title);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
               "isbn='" + isbn + '\'' +
               ", title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", available=" + available +
               '}';
    }
}
