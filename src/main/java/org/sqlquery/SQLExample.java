package org.sqlquery;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class SQLExample {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session s = factory.openSession();

        // SQL Query
        String q = "select * from student";

        NativeQuery query = s.createNativeQuery(q);

        List<Object[]> studentList = query.list();

        for (Object[] st:
                studentList) {
            System.out.println(Arrays.deepToString(st));
        }


        s.close();
        factory.close();

    }
}
