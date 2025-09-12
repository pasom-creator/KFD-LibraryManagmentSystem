package ru.home.util;

import ru.home.model.Book;
import ru.home.model.BorrowedBook;
import ru.home.model.Faculty;
import ru.home.model.Guest;
import ru.home.model.LibraryCard;
import ru.home.model.Student;
import ru.home.model.User;
import ru.home.repository.BookRepository;
import ru.home.repository.LibraryCardRepository;
import ru.home.repository.UserRepository;

import java.time.LocalDate;

public final class TestData {
    private TestData() {
        throw new UnsupportedOperationException("Нельзя создать экземпляр утильного класса");
    }

    public static void loadTestData(BookRepository bookRepository, UserRepository userRepository,
                                    LibraryCardRepository libraryCardRepository) {

        //Add books
        bookRepository.addBook(new Book("978-5-389-01234-5", "Война и мир", "Лев Толстой", true));
        bookRepository.addBook(new Book("978-5-389-01235-2", "Анна Каренина", "Лев Толстой", true));
        bookRepository.addBook(new Book("978-5-389-01236-9", "Воскресение", "Лев Толстой", true));
        bookRepository.addBook(new Book("978-5-17-012347-8", "Преступление и наказание", "Федор Достоевский", true));
        bookRepository.addBook(new Book("978-5-17-012348-5", "Братья Карамазовы", "Федор Достоевский", true));
        bookRepository.addBook(new Book("978-5-17-012349-2", "Идиот", "Федор Достоевский", true));
        bookRepository.addBook(new Book("978-5-699-12456-3", "Вишневый сад", "Антон Чехов", true));
        bookRepository.addBook(new Book("978-5-699-12457-0", "Три сестры", "Антон Чехов", true));
        bookRepository.addBook(new Book("978-5-04-567890-1", "Евгений Онегин", "Александр Пушкин", true));
        bookRepository.addBook(new Book("978-5-04-567891-8", "Капитанская дочка", "Александр Пушкин", true));
        bookRepository.addBook(new Book("978-5-353-78901-2", "Герой нашего времени", "Михаил Лермонтов", true));
        bookRepository.addBook(new Book("978-5-271-89012-3", "Мертвые души", "Николай Гоголь", true));
        bookRepository.addBook(new Book("978-5-271-89013-0", "Ревизор", "Николай Гоголь", true));
        bookRepository.addBook(new Book("978-5-465-90123-4", "Отцы и дети", "Иван Тургенев", true));
        bookRepository.addBook(new Book("978-5-389-23456-7", "Один день Ивана Денисовича", "Александр Солженицын", true));

        //Add users
        User facultyPhilosophy = new Faculty(1001L, "Профессор Иванов Иван Иванович", "ivanov@university.ru");
        User studentPetr = new Student(2001L, "Петров Петр Петрович", "petrov@student.university.ru");
        User studentAnn = new Student(2002L, "Сидорова Анна Владимировна", "sidorova@student.university.ru");
        User guestAlex = new Guest(3001L, "Гостев Алексей Николаевич", "gostev@email.com");
        User guestMarry = new Guest(3002L, "Визитова Мария Сергеевна", "visitova@email.com");

        userRepository.addUser(facultyPhilosophy);
        userRepository.addUser(studentPetr);
        userRepository.addUser(studentAnn);
        userRepository.addUser(guestAlex);
        userRepository.addUser(guestMarry);

        //Get Library card
        LibraryCard philosophyFacultyCard = new LibraryCard(1L, facultyPhilosophy);
        LibraryCard studentPetrCard = new LibraryCard(2L, studentPetr);
        LibraryCard guestAlexCard = new LibraryCard(3L, guestAlex);

        libraryCardRepository.addLibraryCard(philosophyFacultyCard);
        libraryCardRepository.addLibraryCard(studentPetrCard);
        libraryCardRepository.addLibraryCard(guestAlexCard);

        // "Война и мир" и "Преступление и наказание"
        libraryCardRepository.borrowBook("978-5-389-01234-5", 1L); // Война и мир
        bookRepository.changeBookStatus("978-5-389-01234-5");
        libraryCardRepository.borrowBook("978-5-17-012347-8", 1L); // Преступление и наказание
        bookRepository.changeBookStatus("978-5-17-012347-8");

        // "Анна Каренина" и "Братья Карамазовы"
        libraryCardRepository.borrowBook("978-5-389-01235-2", 2L); // Анна Каренина
        bookRepository.changeBookStatus("978-5-389-01235-2");
        libraryCardRepository.borrowBook("978-5-17-012348-5", 2L); // Братья Карамазовы
        bookRepository.changeBookStatus("978-5-17-012348-5");

        // "Вишневый сад" и "Евгений Онегин"
        libraryCardRepository.borrowBook("978-5-699-12456-3", 3L); // Вишневый сад
        bookRepository.changeBookStatus("978-5-699-12456-3");

        libraryCardRepository.getMap().get(1L).getBorrowedBooks().add(
                new BorrowedBook("978-5-389-23456-7",
                        LocalDate.of(2025,9,01),
                        LocalDate.of(2025,9,10)));
        bookRepository.changeBookStatus("978-5-389-23456-7");
    }
}
