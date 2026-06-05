package demo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Students;


public class HQLDemo {
	
	public static void main(String[] args){
		
		Configuration config = new Configuration();
		
		config.configure();
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = null;
		
		try {
			
			session = sessionFactory.openSession();
			
			// Select * from Students;
//			Query<Students> query = session.createQuery("FROM Students", Students.class);
//			
//			List<Students> s = query.list();
//			
//			System.out.println("Student Details: " + s);
			
			// select * from students where id = 1;
			
//			Query<Students> query1 = session.createQuery("From Students where id =:studentId", Students.class);
//			
//			query1.setParameter("studentId", 1);
//			
//			List<Students> studentbyId = query1.list();
//			
//			System.out.println("Student Details: " + studentbyId);
			
//			
//			List<Students> list = query1.list();
//			
//			System.out.println("Student Details: " + list);
			
			// Select * from students where id IN(1, 3);
			
			Query<Students> query2 = session.createQuery("From Students where id IN(:studentId1, :studentId2)", Students.class);
			
			query2.setParameter("studentId1", 1);
			query2.setParameter("studentId2", 3);
			
			List<Students> list = query2.list();
			
			System.out.println("Student Details: " + list);
			
			
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			session.close();
			sessionFactory.close();
		}
	}

}
