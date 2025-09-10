package ru.home.service.impl;

import ru.home.model.Book;
import ru.home.model.BorrowedBook;
import ru.home.model.User;
import ru.home.repository.BookRepository;
import ru.home.repository.LibraryCardRepository;
import ru.home.repository.UserRepository;
import ru.home.service.LibraryService;
import ru.home.service.UserService;
import ru.home.util.TestData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryServiceImpl implements LibraryService, UserService {
    private final BookRepository BOOK_REPOSITORY;
    private final UserRepository USER_REPOSITORY;
    private final LibraryCardRepository LIBRARY_SERVICE;

    public LibraryServiceImpl() {
        this.BOOK_REPOSITORY = new BookRepository();
        this.USER_REPOSITORY = new UserRepository();
        this.LIBRARY_SERVICE = new LibraryCardRepository();
        TestData.loadTestData(BOOK_REPOSITORY, USER_REPOSITORY, LIBRARY_SERVICE);
    }

    @Override
    public boolean borrowBook(String isbn, Long cardId) {
        if (BOOK_REPOSITORY.isBookAvailable(isbn)) {
            if (LIBRARY_SERVICE.borrowBook(isbn, cardId)) {
                BOOK_REPOSITORY.changeBookStatus(isbn);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean returnBook(String isbn, Long cardId) {
        if (LIBRARY_SERVICE.returnBook(isbn, cardId)) {
            BOOK_REPOSITORY.changeBookStatus(isbn);
            return true;
        }
        return false;
    }

    @Override
    public void findOverdueBooks() {
        LIBRARY_SERVICE.findOverdueBooks();
    }

    @Override
    public void sortAllBooksByTitle() {
        List<Book> list = BOOK_REPOSITORY.listAllBooks();
        Collections.sort(list);
        for (Book book : list) {
            System.out.println(book);
        }
    }

    @Override
    public void displayAllAuthors() {
        List<String> authorList = new ArrayList<>(BOOK_REPOSITORY.listAllAuthors());
        Collections.sort(authorList);
        for (String string : authorList) {
            System.out.println(string);
        }
    }

    @Override
    public void displayAllBorrowedBooks() {
        for (BorrowedBook borrowedBook : LIBRARY_SERVICE.displayBorrowedBookList()) {
            System.out.println(borrowedBook);
        }
    }

    @Override
    public void displayAllLibraryCards() {
        LIBRARY_SERVICE.displayAllLibraryCards();
    }

    @Override
    public void createUser(Long id, String name, String email, String type) {
        USER_REPOSITORY.addUser(USER_REPOSITORY.createUser(id, name, email, type));
        System.out.printf("User with id %d is successfully created\n", id);
    }

    @Override
    public void removeUser(Long userId) {
        USER_REPOSITORY.removeUser(userId);
    }

    @Override
    public void listAllUsers() {
        for (User user : USER_REPOSITORY.listUsers()) {
            System.out.println(user);
        }
    }
}
