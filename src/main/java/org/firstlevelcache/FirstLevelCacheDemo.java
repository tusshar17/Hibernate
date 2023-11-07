package org.firstlevelcache;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCacheDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        // First level caching is by default enabled

        // fetching student 101 for first time
        System.out.println("fetching student 101 for first time");
        Student student = session.get(Student.class, 101);
        System.out.println(student);

        System.out.println("----------------");
        System.out.println("fetching student 101 for second time");
        Student student1 = session.get(Student.class, 101);
        System.out.println(student1);





        session.close();
    }
}
