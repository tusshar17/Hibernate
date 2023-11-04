package org.hql;

import jakarta.persistence.Query;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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


        s.close();
        factory.close();


    }
}
