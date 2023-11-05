package org.hql.pagination;

import jakarta.persistence.Query;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQLPagination {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session s = factory.openSession();

        Query query = s.createQuery("from Student");

        // Implementing Pagination
        query.setFirstResult(0);
        query.setMaxResults(5);

        List<Student> studentList = query.getResultList();

        for (Student st:
             studentList) {
            System.out.println(st.getId() + "-" + st.getName());
        }


        s.close();
        factory.close();
    }
}
