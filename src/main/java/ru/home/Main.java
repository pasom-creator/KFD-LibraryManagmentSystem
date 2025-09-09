package ru.home;

import ru.home.model.BorrowedBook;
import ru.home.model.Student;
import ru.home.model.User;
import ru.home.service.LibraryServiceImp;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User studentOne = new Student(1902L, "Pavel", "mdlfjl@nrtj.tu");
        System.out.println(studentOne.getBorrowDaysLimit());

        BorrowedBook borrowedBook = new BorrowedBook("Ui8392", LocalDate.now(), LocalDate.now().plusDays(7));
        System.out.println(borrowedBook);

        LibraryServiceImp service = new LibraryServiceImp();
//        service.listAllUsers();
//        service.displayAllBorrowedBooks();
//        service.displayAllLibraryCards();
//        service.returnBook("978-5-389-01234-5",1L);
//        service.displayAllLibraryCards();
//        service.sortAllBooksByTitle();

        service.findOverdueBooks();

    }
}
