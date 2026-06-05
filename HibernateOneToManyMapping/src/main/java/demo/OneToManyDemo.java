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

public class OneToManyDemo {
	
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
			ques.setId(1);
			ques.setQuestion("What is Hibernate?");
			
			List<Answer> ansList = new ArrayList<Answer>();
			
			Answer ans1 = new Answer();
			ans1.setId(1);
			ans1.setAnswer("Hibernate is ORM framework.");
			ans1.setQuestion(ques);
			
			Answer ans2 = new Answer();
			ans2.setId(2);
			ans2.setAnswer("Hibernate is implementation of JPI Interface.");
			ans2.setQuestion(ques);
			
			ansList.add(ans1);
			ansList.add(ans2);
			
			ques.setAnswer(ansList);
			
			session.persist(ques);
			
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


