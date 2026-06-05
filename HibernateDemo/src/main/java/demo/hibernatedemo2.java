package demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class hibernatedemo2 {
	
public static void main(String[] args) {
	
		Configuration config = new Configuration();
		
		config.configure();
		
		SessionFactory sessionfactory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
	
		try {
			
			session = sessionfactory.openSession();
			
//			transaction = session.beginTransaction();
//			
//			Student student = new Student();
////			student.setId(1);
//			student.setStudentName("Rohan");
//			student.setCity("Pune");
//			
//			Student student2 = new Student();
////			student.setId(1);
//			student2.setStudentName("Sneha");
//			student2.setCity("Hyderabad");
//			
//			Student student3 = new Student();
////			student.setId(1);
//			student3.setStudentName("Raj");
//			student3.setCity("Mumbai");
//			
//			//Create
////			session.save(student);
//			session.persist(student);
//			session.persist(student2);
//			session.persist(student3);
			
			// Update
//			session.update(student);
//			session.merge(student);
			
			// Delete
//			session.delete(student);
//			session.remove(student);
			
			Student student = session.get(Student.class, 1);
			
			System.out.println(student);
			
			
			flag = true;
			
		}
		catch(HibernateException e){
			
			e.printStackTrace();
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		finally {
			
//			if(flag == true) {
//				
//				transaction.commit();
//				
//			}
//			else {
//				transaction.rollback();
//			}
			
			session.close();
			
			sessionfactory.close();
			
		}
		
	}

}
