package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapMain {
	
	public static void main(String[] args) {
		
		
		
		Configuration cfg=new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		
		Question  q1=new Question();
		
		q1.setQuestionId(12);
		q1.setQuestion("what is hibernate ");
		
		
		
		
		Question  q2=new Question();
		q2.setQuestionId(22);
		q2.setQuestion("what is collection ");
		
		
		
		Answer a1=new Answer();
		a1.setAnswerId(333);
		a1.setAnswer("hibernate is a framework of java");
		a1.setQuestion(q1);
		q1.setAnswer(a1);
		
		Answer a2=new Answer();
		a2.setAnswerId(122);
		a2.setAnswer("collection is framework that reprsent a single entity");
		a2.setQuestion(q2);
		q2.setAnswer(a2);
		
		//session
	Session s=factory.openSession();
	
Transaction tr=	s.beginTransaction();
	// save
	s.save(q1);
	s.save(q2);
	s.save(a1);
	s.save(a2);
	
	tr.commit();
		
   s.close();
  factory.close();	
		
		
	}

}
