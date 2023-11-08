package org.xmlmapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session s = factory.openSession();

        Person person = new Person(101, "Raman", "Delhi", "5457559");

        Transaction tx = s.beginTransaction();

        s.save(person);

        tx.commit();
        s.close();
        factory.close();
    }
}
