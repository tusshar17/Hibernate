package org.mapping.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

import java.util.List;
public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // creating author
        Author author1 = new Author();
        author1.setAuthorId(1);
        author1.setAuthorName("Author1");

        // creating books
        Book book1 = new Book();
        book1.setBookId(1);
        book1.setBookTitle("Microservices in Spring Boot");
        book1.setAuthor(author1);

        Book book2 = new Book();
        book2.setBookId(2);
        book2.setBookTitle("Introduction to Python");
        book2.setAuthor(author1);

        List<Book> bookList = new ArrayList<Book>();
        bookList.add(book1);
        bookList.add(book2);
        author1.setBooks(bookList);



        // session
        Session s = factory.openSession();

        Transaction tx = s.beginTransaction();

        s.save(author1);
        s.save(book1);
        s.save(book2);

        tx.commit();

        // fetching an author and it's books
        Author a = (Author) s.get(Author.class, 1);
        System.out.println(a.getAuthorName());

        for (Book b :
                a.getBooks()) {
            System.out.println(b.getBookTitle());
        }


        s.close();
        factory.close();

    }

}
