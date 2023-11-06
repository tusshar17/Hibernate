package org.cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mapping.OneToMany.Author;
import org.mapping.OneToMany.Book;

import java.util.ArrayList;
import java.util.List;

public class CascadeExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session s = factory.openSession();

        // creating a new Author
        Author author = new Author();
        author.setAuthorId(42345345);
        author.setAuthorName("Ashlee Vance");

        // creating Books
        Book book1 = new Book();
        book1.setBookId(34534);
        book1.setBookTitle("Elon Musk");
        book1.setAuthor(author);

        Book book2 = new Book();
        book2.setBookId(34535);
        book2.setBookTitle("Jeff Bezos");
        book2.setAuthor(author);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        author.setBooks(bookList);

        Transaction tx = s.beginTransaction();
        s.save(author);


        tx.commit();
        s.close();
        factory.close();

    }
}
