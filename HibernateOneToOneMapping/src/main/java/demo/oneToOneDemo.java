package demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Answer;
import entity.Question;

public class oneToOneDemo {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		
		config.configure();
		
		SessionFactory sessionfactory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		Boolean flag = false;
		
		try {
			
			session = sessionfactory.openSession();
			
			transaction = session.beginTransaction();
			
			Question ques = new Question();
//			ques.setId(1);
			ques.setQuestion("What is Hibernate?");
			
			
			Answer ans = new Answer();
//			ans.setId(1);
			ans.setAnswer("Hibernate is ORM framework.");
			ans.setQuestion(ques);
			
			session.persist(ques);
			
			// Fetching the data
			
//			Question ques = session.get(Question.class, 1);
//			
//			System.out.println(ques);
			
			flag = true;
			
		}
		catch(HibernateException e) {
			
			e.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
//			if(flag == true) {
//				transaction.commit();
//			}
//			else {
//				transaction.rollback();
//			}
			
			session.close();
			sessionfactory.close();
		}
		
	}

}
