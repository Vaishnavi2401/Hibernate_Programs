package demo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Students;

public class HQLUpdateDemo {
	
public static void main(String[] args){
		
		Configuration config = new Configuration();
		
		config.configure();
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		Integer count = 0;
		
		boolean flag = false;
		
		try {
			
			session = sessionFactory.openSession();
			
			transaction = session.beginTransaction();
			
//			count = session.createMutationQuery("Update Students set sname=:name where sname=:oldname").setParameter("name", "Sneha").setParameter("oldname", "Rohan").executeUpdate();
			
			count = session.createMutationQuery("Delete from Students where id =:studentId").setParameter("studentId", 3).executeUpdate();
			
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
			sessionFactory.close();
		}
	}

}
