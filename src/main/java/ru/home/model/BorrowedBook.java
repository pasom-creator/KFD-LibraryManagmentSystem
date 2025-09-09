package ru.home.model;

import java.time.LocalDate;

public class BorrowedBook extends Book {
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowedBook(String isbn, LocalDate borrowDate, LocalDate returnDate) {
        super(isbn);
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
               "isbn= " + super.getIsbn() +
               ", borrowDate= " + borrowDate +
               ", returnDate= " + returnDate +
               '}';
    }
}
