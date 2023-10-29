package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Student s1 = new Student();
        s1.setId(12232);
        s1.setName("Ankit");
        s1.setCity("Mumbai");

        Certificate certificate = new Certificate();
        certificate.setCourse("Python");
        certificate.setDuration("6 Months");

        s1.setCertificate(certificate);

        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();

        session.save(s1);

        tr.commit();
        session.close();
        factory.close();
    }
}
