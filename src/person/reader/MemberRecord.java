package person.reader;

import Shared.CustomDate;
import book.Book;
import book.BookStatus;
import library.Library;

import java.util.*;

public class MemberRecord {
    private long member_id;
    private Library library;
    private Reader reader;
    private membershipType type;
    private CustomDate date_of_membership;
    private Set<Book> lendedBooks = new HashSet<>();
    private final int  MAX_LENDED_BOOKS = 5;
    private double dept;

    public MemberRecord() {
    }

    public MemberRecord(long member_id, membershipType type, Reader reader, Library library) {
        this.member_id = member_id;
        this.type = type;
        this.reader = reader;
        this.library = library;
        dept = 0;
    }

    public double getDept() {
        return dept;
    }

    public Set<Book> getLendedBooks() {
        return lendedBooks;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public boolean addBookToLendedBooks(Book book) {
        if (lendedBooks.size()<6){
            lendedBooks.add(book);
            System.out.println("Kitap fiyatları " + book.getPrice());
            dept += book.getPrice();
        }
        return true;
    }

    public boolean returnBook(long id) {
        Book book = library.get_book(id);

        if (book == null) {
            System.out.println("Book does not exist!");
            return false;
        }

        if (!lendedBooks.contains(book)) {
            System.out.println("This book was not lent out!");
            return false;
        }

        book.setStatus(BookStatus.AVAILABLE);
        lendedBooks.remove(book);
        book.setOwner(null);
        System.out.println("Book " + book.getName() + " has been returned successfully.");

        dept -= book.getPrice();
        return true;
    }

    @Override
    public String toString() {
        return "MemberRecord{" +
                "Reader = " + this.reader +
                '}';
    }
}
