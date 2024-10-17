package book;

import Shared.CustomDate;
import person.Author;
import person.Person;
import person.reader.MemberRecord;
import person.reader.Reader;

import java.time.LocalDate;
import java.util.Objects;

public class Book implements Comparable{
    private long bookId;
    private Author author;
    private MemberRecord owner;
    private String name;
    private String title;
    private GenreEnum genre;
    private double price;
    private BookStatus status;
    private BookEdition edition;
    private CustomDate dateofpurches;
    private CustomDate dateoflending;

    public Book(long bookId, Author author, String name, String title, double price, BookEdition edition, CustomDate dateofpurches, GenreEnum genre) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.genre = genre;
        this.title = title;
        this.price = price;
        this.status = BookStatus.AVAILABLE;
        this.edition = edition;
        this.dateofpurches = dateofpurches;
    }

    public Book lendBook(MemberRecord owner){
        this.owner = owner;
        setStatus(BookStatus.ON_HOLD);
        setDateoflending(CustomDate.now());
        return this;
    }

    public Book giveBackBook(){
        setDateoflending(null);
        this.owner = null;
        setStatus(BookStatus.AVAILABLE);
        return this;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public long getBookId() {
        return bookId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setOwner(MemberRecord owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void setEdition(BookEdition edition) {
        this.edition = edition;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setDateofpurches(CustomDate dateofpurches) {
        this.dateofpurches = dateofpurches;
    }

    public String getName() {
        return name;
    }

    public String get_title() {
        return title;
    }

    public Author get_author() {
        return author;
    }

    public void change_owner(MemberRecord owner) {
        this.owner = owner;
    }

    public MemberRecord get_owner() {
        return owner;
    }

    public CustomDate getDateoflending() {
        return dateoflending;
    }

    public void setDateoflending(CustomDate dateoflending) {
        this.dateoflending = dateoflending;
    }

    public String display() {
        return "Book{" +
                "bookId=" + bookId +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition=" + edition +
                ", dateofpurches=" + dateofpurches +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && Objects.equals(name, book.name) && Objects.equals(title, book.title);
    }


    @Override
    public int hashCode() {
        return Objects.hash(bookId, name, title);
    }

    @Override
    public int compareTo(Object o) {
        Book book = (Book) o;
        if(book.equals(this))return 0;
        return this.dateoflending.isEarlierThan(book.getDateoflending()) ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", title='" + title + '\'' +
                '}';
    }
}
