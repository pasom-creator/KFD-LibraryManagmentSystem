# KFD Test Assignment: Library Management System

## Task Description

Create a console-based library management system. This assignment tests your understanding of **OOP principles** and **data structures** - the foundation skills needed for our Kotlin course.

### What to Build
A working console application that manages:
- **Books** (add, remove, search)
- **Users** (different types: Student, Faculty, Guest) 
- **Borrowing operations** (borrow, return, track overdue)

### Business Rules
- **Student**: max 3 books, 14 days
- **Faculty**: max 10 books, 30 days  
- **Guest**: max 1 book, 7 days
- Books cannot be borrowed if unavailable
- Users cannot exceed their borrowing limit


## 💻 Технологии

Для реализации проекта использовалась:
- Java 17


## Структура приложения
```
home
 ┣ 📂controller
 ┃ ┣ 📜BookControlMenu.java
 ┃ ┣ 📜GeneralMenu.java
 ┃ ┣ 📜MainMenu.java
 ┃ ┗ 📜UserControlMenu.java
 ┣ 📂model
 ┃ ┣ 📜Book.java
 ┃ ┣ 📜BorrowedBook.java
 ┃ ┣ 📜Faculty.java
 ┃ ┣ 📜Guest.java
 ┃ ┣ 📜LibraryCard.java
 ┃ ┣ 📜Student.java
 ┃ ┗ 📜User.java
 ┣ 📂repository
 ┃ ┣ 📜BookRepository.java
 ┃ ┣ 📜LibraryCardRepository.java
 ┃ ┗ 📜UserRepository.java
 ┣ 📂service
 ┃ ┣ 📂impl
 ┃ ┃ ┗ 📜LibraryServiceImpl.java
 ┃ ┣ 📜BookService.java
 ┃ ┣ 📜LibraryService.java
 ┃ ┗ 📜UserService.java
 ┣ 📂util
 ┃ ┣ 📜ConsoleReader.java
 ┃ ┗ 📜TestData.java
 ┗ 📜Main.java
```

## Краткое описание приложения

Приложение позволяет:
- добавлять\удалять\осуществлять фильтрацию\поиск книг в библиотеке.
- добавлять\удалять пользователей
- создавать\удалять\управлять карточками читаля

Пользователи регистрируются в библиотеке по средствам карточки читателя и добавляют в неё книги, из числа доступных в хранилище. После добавления в карточку читателя книга становиться не доступной для других пользователей. Для удоства использования каждый пункт консольного меню сопровождается подсказками. В приложение имеется список тестовых данных - книг,пользователей,карточек читаля.

Управление в приложение осуществляется при помощи консольного меню. 
Главное меню предоставляет выбор из трёх позиций: 
1. Панель управления пользователями
2. Панель управления книгами
3. Панель управления операциями в библиотеке

