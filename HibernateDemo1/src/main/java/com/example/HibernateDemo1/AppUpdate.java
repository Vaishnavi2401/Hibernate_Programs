package com.example.HibernateDemo1;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.HibernateDemo1.model.User;

public class AppUpdate {
	
	public static void main(String[] args){
		
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
		
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		
		try {
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			User user = new User();
			user.setId(4);
			user.setName("New User");
			user.setEmail("newuser112@example.com");
			
			
			session.merge(user); // updation
			// session.remove(user); // Deletion
			
			flag = true;
			
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			if(flag == true) {
				transaction.commit();
			}
			else {
				transaction.rollback();
			}
			
			session.close();
			sessionFactory.close();
		}
		
	}

}
