package person;

import book.Book;

import java.util.HashSet;
import java.util.Set;

public class Author extends Person{
    private Set<Book> books;

    public Author(String name) {
        this.name = name;
        this.books = new HashSet<>();
    }

    public Author(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }


    public Set<Book> show_book() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public boolean new_book(Book book){
        if(!books.contains(book)){
            books.add(book);
            return true;
        }else return false;
    }

    @Override
    public String whoyouare() {
        return "Author{" +
                "name" + name +
                "books=" + books +
                '}';
    }
}
