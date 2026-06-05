package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class HibernateDemo {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		
		config.configure();
		
		SessionFactory sessionfactory = config.buildSessionFactory();
		
		Session session = sessionfactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setId(1);
		student.setStudentName("Rohan");
		student.setCity("Pune");
		
		session.save(student);
		
		transaction.commit();
		
		session.close();
		
		sessionfactory.close();
		
	}

}
