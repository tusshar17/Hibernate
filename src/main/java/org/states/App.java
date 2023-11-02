package org.states;

import org.example.Certificate;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // creating student object
        Student student = new Student();
        student.setId(2233);
        student.setName("Henry");
        student.setCity("Kanpur");
        student.setCertificate(new Certificate("AI", "2 months"));

        // till now student is in Transient State (neither in session nor in DB)

        Session s = f.openSession();
        Transaction tx = s.beginTransaction();
        s.save(student);
        // now student is in Persistence State (in both session and DB)

        student.setName("John");

        tx.commit();

        s.close();
        // after closing session student is in Detached State (in DB but not in session)

        student.setName("Sam");

        System.out.println(student);




        f.close();
    }
}
