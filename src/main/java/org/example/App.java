package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {

        System.out.println( "Hello World!" );

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // creating a Student
        Student st = new Student();
        st.setId(101);
        st.setName("Rohan");
        st.setCity("Jaipur");

        System.out.println(st);


        // creating address
        Address address = new Address();
        address.setStreet("street-1");
        address.setCity("Delhi");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(12.23);

        // image
        FileInputStream fileInputStream = new FileInputStream("src/main/java/5968282.png");
        try {
            byte[] data = new byte[fileInputStream.read()];
            address.setImage(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(address);
        tx.commit();
        session.close();

    }
}
