package library;

import book.Book;

import book.BookStatus;
import book.GenreEnum;
import person.Author;
import person.reader.MemberRecord;
import person.reader.Reader;

import java.util.*;

public class Library {
    private Map<Long, Book> books;
    private Map<String, Reader> readers;

    public Library() {
        this.books = new HashMap<>();
        this.readers = new HashMap<>();
    }

    public Library(Map<Long, Book> books, Map<String, Reader> readers) {
        this.books = (books != null) ? books : new HashMap<>();
        this.readers = (readers != null) ? readers : new HashMap<>();
    }

    public Map<Long, Book> get_book() {
        return books;
    }

    public Book get_book(long id) {
        return books.get(id);
    }

    public Book get_book(String name) {
        for ( Book book : books.values()) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public Set<Book> get_book(Author author) {
        Set<Book> bookSet = new HashSet<>();
        for (Book book : books.values()) {
            if (book.get_author().equals(author)) {
                bookSet.add(book);
            }
        }
        return bookSet.isEmpty() ? null : bookSet;
    }

    public boolean deleteBook(long id){
        Book book = books.remove(id);
        return book != null;
    }

    public List<Book> getBooksByGenre(GenreEnum genre) {
        List<Book> bookList = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getGenre().equals(genre)) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    public Map<String, Reader> get_readers() {
        return readers;
    }

    public Reader searchForReader(String name) {
        return readers.get(name);
    }

    public boolean new_book(Book book) {
        if (book == null || books.containsKey(book.getBookId())) {
            return false;
        } else {
            books.put(book.getBookId(), book);
            return true;
        }
    }

    public boolean addReader(Reader reader){
        if (reader != null){
            readers.put(reader.name,reader);
            System.out.println(reader.name + " is added to library");
            return true;
        }else {
            System.out.println("Reader is null");
            return false;
        }
    }


    public boolean lendBook(long bookId, String readerName) {
        Book book = get_book(bookId);
        boolean success = false;
        if (book == null) {
            System.out.println("Book with ID " + bookId + " is not in the library.");
            return false;
        } else if (book.getStatus()!= BookStatus.AVAILABLE) {
            System.out.println("Book is not available");
            return false;
        }

        Reader reader = searchForReader(readerName);
        if (reader == null) {
            System.out.println("Reader " + readerName + " is not signed in!");
            return false;
        }

        MemberRecord record = reader.getMember_record();
        if (record != null) {
            success = record.addBookToLendedBooks(book);
        } else {
            System.out.println("Please create a record to lend a book.");
            return false;
        }

        if (success) {
            book.lendBook(record);
            System.out.println("Book with ID " + bookId + " successfully lent to " + readerName + ".");
        } else {
            System.out.println("Failed to lend book with ID " + bookId + " to " + readerName + ".");
        }
        return success;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                '}';
    }
}
