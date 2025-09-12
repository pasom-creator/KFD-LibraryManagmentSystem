package ru.home.repository;

import ru.home.model.BorrowedBook;
import ru.home.model.LibraryCard;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class LibraryCardRepository {
    private final Map<Long, LibraryCard> LIBRARY_CARD_STORAGE;

    public LibraryCardRepository() {
        this.LIBRARY_CARD_STORAGE = new HashMap<>();
    }

    public void addLibraryCard(LibraryCard libraryCard) {
        if (!LIBRARY_CARD_STORAGE.containsKey(libraryCard.getId())) {
            LIBRARY_CARD_STORAGE.put(libraryCard.getId(), libraryCard);
        }
    }

    public int removeLibraryCard(Long cardId) {
        if (!LIBRARY_CARD_STORAGE.isEmpty()&&LIBRARY_CARD_STORAGE.containsKey(cardId)) {
            if (LIBRARY_CARD_STORAGE.get(cardId).getBorrowedBooks().isEmpty()) {
                LIBRARY_CARD_STORAGE.remove(cardId);
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public void displayAllLibraryCards() {
        for (Map.Entry<Long, LibraryCard> cardEntry : LIBRARY_CARD_STORAGE.entrySet()) {
            System.out.printf("Card id %d: %s\n", cardEntry.getKey(), cardEntry.getValue());
        }
    }

    public boolean borrowBook(String isbn, Long cardId) {
        LibraryCard libraryCard = LIBRARY_CARD_STORAGE.get(cardId);
        if (libraryCard.getBorrowedBooks().size() < libraryCard.getUser().getBooksLimit()) {
            libraryCard.getBorrowedBooks().add(
                    new BorrowedBook(
                            isbn,
                            LocalDate.now(),
                            LocalDate.now().plusDays(libraryCard.getUser().getBorrowDaysLimit())));
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn, Long cardId) {
        if (LIBRARY_CARD_STORAGE.containsKey(cardId)) {
            ListIterator<BorrowedBook> borrowedBook = LIBRARY_CARD_STORAGE.get(cardId).getBorrowedBooks().listIterator();
            while (borrowedBook.hasNext()) {
                if (borrowedBook.next().getIsbn().equalsIgnoreCase(isbn)) {
                    borrowedBook.remove();
                    return true;
                }
            }
        }
        return false;
    }

    public void findOverdueBooks() {
        for (Map.Entry<Long, LibraryCard> bookEntry : LIBRARY_CARD_STORAGE.entrySet()) {
            for (BorrowedBook borrowedBook : bookEntry.getValue().getBorrowedBooks()) {
                long dayLimit = ChronoUnit.DAYS.between(borrowedBook.getBorrowDate(), borrowedBook.getReturnDate());
                if (dayLimit > bookEntry.getValue().getUser().getBorrowDaysLimit()
                    || borrowedBook.getReturnDate().isBefore(LocalDate.now())) {
                    System.out.println(bookEntry.getKey() + " : " + borrowedBook);
                }
            }
        }
    }

    public List<BorrowedBook> displayBorrowedBookList() {
        List<BorrowedBook> list = new ArrayList<>();
        for (Map.Entry<Long, LibraryCard> bookEntry : LIBRARY_CARD_STORAGE.entrySet()) {
            list.addAll(bookEntry.getValue().getBorrowedBooks());
        }
        return list;
    }

    //This method is used to upload testing data only
    public Map<Long, LibraryCard> getMap() {
        return LIBRARY_CARD_STORAGE;
    }
}
