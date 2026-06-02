package com.example.HibernateDemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.HibernateDemo1.model.User;

public class App {
    public static void main(String[] args) {
    	
    	Configuration config = new Configuration();
    	
    	config.configure();
    	
    	SessionFactory sessionFactory = config.buildSessionFactory();
    	
    	Session session = sessionFactory.openSession();
    	
    	Transaction transaction = session.beginTransaction();
    	
    	User user = new User();
    	user.setId(4);
    	user.setName("test User 2");
    	user.setEmail("test28@yopmail.com");
    	
    	session.persist(user);
    	transaction.commit();
    	
    	session.close();
    	sessionFactory.close();
        
    }
}
