package book.bookSubClasses;

import Shared.CustomDate;
import book.Book;
import book.BookEdition;
import book.GenreEnum;
import person.Author;

public class Journals extends Book {
    public Journals(long bookId, Author author, String name, String title, double price, BookEdition edition, CustomDate dateofpurches, GenreEnum genre) {
        super(bookId, author, name, title, price, edition, dateofpurches,genre);
    }
}
