package demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Courses;
import entity.Students;

public class HibernateManyToManyDemo {

	public static void main(String[] args){
		
		Configuration config = new Configuration();
		
		config.configure();
		
		SessionFactory sessionfactory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		Boolean flag = false;
		
		try {
			
			session = sessionfactory.openSession();
			
			transaction = session.beginTransaction();
			 
			List<Courses> b1 = new ArrayList<>();
			List<Courses> b2 = new ArrayList<>();
			
			Courses course1 = new Courses();
			course1.setCourseName("Java");
			course1.setFees(2000);
			
			Courses course2 = new Courses();
			course2.setCourseName("DataBase");
			course2.setFees(1500);
			
			Courses course3 = new Courses();
			course3.setCourseName(".NET");
			course3.setFees(1800);
			
			b1.add(course3);
			b1.add(course2);
			b1.add(course1);
			
			b2.add(course1);
			b2.add(course2);
			
			
			Students s1 = new Students();
			s1.setSname("Rohan");
			s1.setCourses(b1);
			
			Students s2 = new Students();
			s2.setSname("Jaya");
			s2.setCourses(b2);
			
			Students s3 = new Students();
			s3.setSname("Jyoti");
			s3.setCourses(b1);
			
			Students s4= new Students();
			s4.setSname("Nishant");
			s4.setCourses(b2);
			
			
			session.persist(s1);
			session.persist(s2);
			session.persist(s3);
			session.persist(s4);
			
//			Students s = session.get(Students.class, 1);
//			
//			System.out.println(s);
			
			flag = true;
			
		}
		catch(HibernateException e) {
			
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
			sessionfactory.close();
		}
		
	}
		
}
