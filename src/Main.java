import Shared.CustomDate;
import book.Book;
import book.BookEdition;
import book.GenreEnum;
import library.Library;
import person.Author;
import person.Librarian;

import person.reader.MemberRecord;
import person.reader.Reader;
import person.reader.membershipType;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Author author = new Author("Ridvan");
        Reader mete = new Reader("mete");
        MemberRecord meteRecord = new MemberRecord(1, membershipType.PREMIUM,mete,library);

        Librarian librarian = new Librarian("Ridvan","bekar5561",library);
        librarian.addReaderToLibrary(mete);
        librarian.createRecord(mete,meteRecord);

        Book book1 = new Book(1,author,"Narnia", "Cadı, kapı, aslan 1",20.00, BookEdition.FIRST_EDITION, new CustomDate(1,1,1998),GenreEnum.ADVENTURE);
        Book book2 = new Book(2,author,"Narnia 1","Cadı, kapı, aslan 2",18.00, BookEdition.FIRST_EDITION, new CustomDate(1,1,1998),GenreEnum.ADVENTURE);
        Book book3 = new Book(3,author,"Narnia 2","Cadı, kapı, aslan 3",16.00, BookEdition.FIRST_EDITION, new CustomDate(1,1,1998),GenreEnum.ADVENTURE);
        Book book4 = new Book(4,author,"Atatürk","Ülke nasıl kurulur?",300.00, BookEdition.HARDCOVER_EDITION, new CustomDate(1,1,1881),GenreEnum.HISTORICAL);
        Book book5 = new Book(5,author,"Atatürk","Ülke nasıl kurulur?",300.00, BookEdition.HARDCOVER_EDITION, new CustomDate(1,1,1881),GenreEnum.HISTORICAL);

        library.new_book(book1);
        library.new_book(book2);
        library.new_book(book3);
        library.new_book(book4);
        library.new_book(book5);

        System.out.println("menekşe");
        library.get_book(1);
        System.out.println(library.get_book(2));
        System.out.println("menekşe");
        library.lendBook(3,"mete");
        library.lendBook(1,"mete");
        library.lendBook(2,"mete");
        librarian.giveBackBook(1);
        System.out.println(meteRecord.getDept());

        Book istegim = library.get_book(2);
        library.lendBook(3,"mete");
    }
}