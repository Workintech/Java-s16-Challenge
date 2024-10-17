package person;

import book.Book;
import book.BookStatus;
import book.GenreEnum;
import library.Library;
import person.reader.MemberRecord;
import person.reader.Reader;


import java.util.*;

public class Librarian extends Person{
    private String password;
    private Library library;

    public Library getLibrary() {
        return library;
    }

    public Librarian(String name, String password, Library library) {
        this.name = name;
        this.password = password;
        this.library = library;
    }

    @Override
    public String whoyouare() {
        return "Librarian :" +
                "Name :" + name;
    }

    public boolean createRecord(Reader reader, MemberRecord memberRecord){
        reader.setMember_record(memberRecord);
        return true;
    }

    public boolean addReaderToLibrary(Reader reader){
        boolean success = library.addReader(reader);
        if (success){
            System.out.println(reader.name + " is added to " + library);
        }else System.out.println("Not successful");
        return success;
    }

    public boolean giveBackBook(long bookId) {
        Book book = library.get_book(bookId);
        MemberRecord record;

        if (book == null) {
            System.out.println("Book with ID " + bookId + " signed in to library.");
            return false;
        } else if (book.getStatus()!=BookStatus.ON_HOLD) {
            System.out.println("Book is not lended!");
            return false;
        }else {
            record = book.get_owner();
            book.giveBackBook();
        }

        if (record != null){
            record.returnBook(bookId);
            System.out.println("Book with ID " + bookId + " has been successfully returned.");
            return true;
        }
        System.out.println("Book with ID " + bookId + " has no owner record.");
        return false;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "password='" + password + '\'' +
                ", library=" + library +
                ", name='" + name + '\'' +
                '}';
    }
}
