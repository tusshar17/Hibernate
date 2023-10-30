package org.mapping.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // creating Employees
        Employee employee1 = new Employee();
        employee1.setEmployeeId(101);
        employee1.setEmployeeName("Joe");

        Employee employee2 = new Employee();
        employee2.setEmployeeId(102);
        employee2.setEmployeeName("Harry");

        // creating projects
        Project project1 = new Project();
        project1.setProjectId(201);
        project1.setProjectTitle("E-Commerce");

        Project project2 = new Project();
        project2.setProjectId(202);
        project2.setProjectTitle("Chat Bot");

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(employee1);
        employees.add(employee2);

        List<Project> projects = new ArrayList<Project>();
        projects.add(project1);
        projects.add(project2);

        project1.setEmployeeList(employees);

        employee2.setProjectList(projects);

        // session
        Session s = factory.openSession();

        Transaction tx = s.beginTransaction();

        s.save(project1);
        s.save(project2);

        s.save(employee1);
        s.save(employee2);

        tx.commit();
        s.close();
        factory.close();


    }
}
