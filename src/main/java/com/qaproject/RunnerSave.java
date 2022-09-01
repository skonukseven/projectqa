package com.qaproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerSave {

	public static void main(String[] args) {

	Question q1 = new Question();
	Question q2 = new Question();
	Question q3 = new Question();
	
	
	QuestionDetail d1 = new QuestionDetail();
	QuestionDetail d2 = new QuestionDetail();
	QuestionDetail d3 = new QuestionDetail();
	
	Answer a1 = new Answer();
	Answer a2 = new Answer();
	Answer a3 = new Answer();
	
	q1.setId(1);
	q1.setName("past");
	q1.setDifficulty(Level.DIFFICULT);
	
	q2.setId(2);
	q2.setName("exercise");
	q2.setDifficulty(Level.EASY);
	
	q3.setId(3);
	q3.setName("past");
	q3.setDifficulty(Level.MEDIUM);
	
	
	d1.setId(01);
	d1.setStandard("s1");
	d1.setQuestions(q3);
	
	d2.setId(02);
	d2.setStandard("s2");
	d2.setQuestions(q1);
	
	d3.setId(03);
	d3.setStandard("s3");
	
	
	
	a1.setId(001);
	a1.setMethod("direct");
	a1.setStrategy("St1");
	a1.setQuestions(q3);
	
	a2.setId(002);
	a2.setMethod("indirect");
	a2.setStrategy("St2");
	a2.setQuestions(q3);
	
	a3.setId(003);
	a3.setMethod("direct");
	a3.setStrategy("St3");
	a3.setQuestions(q2);
	
	Configuration con=new  Configuration().configure("hibernate.cfg.xml").
			   addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class).
			   addAnnotatedClass(QuestionDetail.class);
	
	SessionFactory sf=con.buildSessionFactory();
	Session session= sf.openSession();
	
	Transaction tx= session.beginTransaction();
	
	session.save(q1);
	session.save(q2);
	session.save(q3);
	session.save(a1);
	session.save(a2);
	session.save(a3);
	session.save(d1);
	session.save(d2);
	session.save(d3);
	

	//
	//it makes data to write into database, makes data permanent 
	tx.commit();
	
	//we have to call session close to release connection
	session.close();
	sf.close();
	
	
	
	}

}
