package com.example.HibernateDemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.HibernateDemo1.model.User;

public class App {
    public static void main(String[] args) {
        
        // 1. Create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // 2. Open a Session
        Session session = factory.openSession();
        
        // 3. Begin a Transaction
        Transaction tx = session.beginTransaction();

        try {
            // 4. Create and Save a User Object
            User user = new User(1, "John Doe", "john@example.com");
            session.persist(user);

            // 5. Commit Transaction
            tx.commit();
            System.out.println("User successfully saved to database!");
            
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            // 6. Close resources
            session.close();
            factory.close();
        }
    }
}
