package org.secondlevelcache;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCacheDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // session 1
        Session session1 = factory.openSession();

        Student student1 = session1.get(Student.class, 101);
        System.out.println(student1);


        session1.close();



        // session 2
        Session session2 = factory.openSession();

        Student student2 = session1.get(Student.class, 101);
        System.out.println(student2);


        session2.close();
        
    }
}
