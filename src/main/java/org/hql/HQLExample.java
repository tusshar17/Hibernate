package org.hql;

import jakarta.persistence.Query;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HQLExample {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session s = factory.openSession();

        // HQL
        // Syntax


        String query = "from Student where city = :x ";
        Query q = s.createQuery(query);
        q.setParameter("x", "Jaipur");

        // single - unique
        // multiple - list
        List<Student> studentList = q.getResultList();
        System.out.println(studentList);
        System.out.println("-----------------");



        Transaction tx = s.beginTransaction();

        // Delete Query
        /*
        Query q2 = s.createQuery("delete from Student where city = :c");
        q2.setParameter("c", "Kanpur");
        int numOfRecordsDeleted = q2.executeUpdate();  // return number (how many records deleted)
        System.out.println("Deleted " + numOfRecordsDeleted + " record(s)");
         */



        // Update Query
        Query q3 = s.createQuery("update Student set city= :c where name = :n");
        q3.setParameter("c", "Raipur");
        q3.setParameter("n", "Rohan");
        int numOfRecordsUpdated = q3.executeUpdate();
        System.out.println(numOfRecordsUpdated + " record(s) updated.");



        // Join Query
        Query q4 = s.createQuery("select a.authorName, b.bookTitle from Author as a INNER JOIN a.books as b");
        List<Object []> listOfBooks = q4.getResultList();

        for (Object [] arr:listOfBooks) {
            System.out.println(Arrays.toString(arr));
        }


        tx.commit();
        s.close();
        factory.close();


    }
}
