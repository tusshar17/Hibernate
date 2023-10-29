package org.mapping.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // creating question
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is Java?");

        // creating answer
        Answer a1 = new Answer();
        a1.setAnswerId(22);
        a1.setAnswer("Java is a programming language");
        a1.setQuestion(q1);

        q1.setAnswer(a1);

        // creating question
        Question q2 = new Question();
        q2.setQuestionId(1313);
        q2.setQuestion("What is Spring?");

        // creating answer
        Answer a2 = new Answer();
        a2.setAnswerId(33);
        a2.setAnswer("Spring is a FrameWork");
        a2.setQuestion(q2);

        q2.setAnswer(a2);

        // session
        Session s = factory.openSession();

        Transaction tx = s.beginTransaction();

        s.save(a1);
        s.save(a2);

        s.save(q1);
        s.save(q2);

        tx.commit();

        // fetching
        Question newQ = s.get(Question.class, 1313);
        System.out.println(newQ.getQuestion());
        System.out.println(newQ.getAnswer().getAnswer());

        s.close();


        factory.close();

    }
}
