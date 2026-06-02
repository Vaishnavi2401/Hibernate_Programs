package com.example.HibernateDemo1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.HibernateDemo1.model.User;

public class AppDataretrival {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
		
		Session session = null;
		try {
			
			session = sessionFactory.openSession();
			
			//User u = session.load(User.class, 1); // Lazy Loading
			// User u = session.getReference(User.class, 1); // Lazy Loading
			User u = session.get(User.class, 1); // Eager Loading
			
			System.out.println(u);
			
		}
		catch(HibernateException e) {
			
			e.printStackTrace();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			session.close();
			sessionFactory.close();
		}
		
	}

}
