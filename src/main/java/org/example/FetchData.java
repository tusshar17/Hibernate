package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        // get student
        Student student = (Student) session.get(Student.class, 101);
        System.out.println(student);

        Address address = (Address) session.load(Address.class, 1);
        System.out.println(address);


        factory.close();
    }
}
