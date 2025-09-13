package ru.home.service.impl;

import ru.home.model.Book;
import ru.home.model.BorrowedBook;
import ru.home.model.User;
import ru.home.repository.BookRepository;
import ru.home.repository.LibraryCardRepository;
import ru.home.repository.UserRepository;
import ru.home.service.BookService;
import ru.home.service.LibraryService;
import ru.home.service.UserService;
import ru.home.util.TestData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LibraryServiceImpl implements LibraryService, UserService, BookService {
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
    public void createLibraryCard(Long libraryCardId, Long userId) {
        LIBRARY_SERVICE.addLibraryCard(
                LIBRARY_SERVICE.createLibraryCard(libraryCardId, USER_REPOSITORY.getUser(userId))
        );
        System.out.printf("Library card %d is successfully created\n", libraryCardId);
    }

    @Override
    public void removeLibraryCard(Long cardId) {
        int answer = LIBRARY_SERVICE.removeLibraryCard(cardId);
        if (answer == 1) {
            System.out.println("Library card is successfully deleted");
        } else if (answer == 2) {
            System.out.println("You need to return all borrowed books first");
        } else {
            System.out.println("Wrong library card id");
        }
    }

    @Override
    public void displayAllLibraryCards() {
        LIBRARY_SERVICE.displayAllLibraryCards();
    }

    @Override
    public void borrowBook(String isbn, Long cardId) {
        if (BOOK_REPOSITORY.isBookAvailable(isbn)) {
            if (LIBRARY_SERVICE.borrowBook(isbn, cardId)) {
                BOOK_REPOSITORY.changeBookStatus(isbn);
                System.out.printf("Book %s is borrowed successfully\n", isbn);
            } else {
                System.out.println("Превышен лимит на взятие книг");
            }
        } else {
            System.out.println("This book is unavailable");
        }
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
    public void displayAllBorrowedBooks() {
        for (BorrowedBook borrowedBook : LIBRARY_SERVICE.displayBorrowedBookList()) {
            System.out.println(borrowedBook);
        }
    }

    @Override
    public void findOverdueBooks() {
        LIBRARY_SERVICE.findOverdueBooks();
    }

    @Override
    public void addBook(Book book) {
        BOOK_REPOSITORY.addBook(book);
        System.out.printf("Book %s is added to library\n", book.getTitle());
    }

    @Override
    public void removeBook(String isbn) {
        BOOK_REPOSITORY.removeBook(isbn);
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
    public void displayAllBookAuthors() {
        List<String> authorList = new ArrayList<>(BOOK_REPOSITORY.listAllAuthors());
        Collections.sort(authorList);
        for (String string : authorList) {
            System.out.println(string);
        }
    }

    @Override
    public void findBookByIsbn(String isbn) {
        Book book = BOOK_REPOSITORY.findBookByIsbn(isbn);
        if (Objects.nonNull(book)) {
            System.out.println(book);
        } else {
            System.out.printf("No book with ISBN %s in library\n", isbn);
        }
    }

    @Override
    public void findBookByAuthor(String author) {
        List<Book> list = BOOK_REPOSITORY.findBookByAuthor(author);
        if (!list.isEmpty()) {
            for (Book book : list) {
                System.out.println(book);
            }
        } else {
            System.out.printf("There is no %s in library\n", author);
        }
    }

    @Override
    public void findBookByTitle(String title) {
        Book book = BOOK_REPOSITORY.findBookByTitle(title);
        if (Objects.nonNull(book)) {
            System.out.println(book);
        } else {
            System.out.printf("No book with this name %s find\n", title);
        }
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
