package person.reader;

import book.Book;
import book.BookStatus;
import person.Person;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class Reader extends Person {
    private MemberRecord member_record;

    public Reader(String name) {
        this.name = name;
    }

    public Reader(String name, MemberRecord member_record) {
        this.name = name;
        this.member_record = member_record;
    }

    public MemberRecord getMember_record(){
        if (member_record == null) {
            System.out.println("Not a member");
            return new MemberRecord();
        };
        return member_record;
    }

    public void setMember_record(MemberRecord member_record) {
        this.member_record = member_record;
    }

    @Override
    public String whoyouare() {
        return "Reader{" +
                ", name='" + name + '\'' +
                "member_record=" + member_record +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(name, reader.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                '}';
    }
}
