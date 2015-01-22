package com.hibernateExample.HibernateTest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernateExample.HibernateSession.HibernateSessionFactory;
import com.hibernateExample.entity.SimpleBook;

public class directTest {

	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param @param args     
	 * @return void     
	 * @throws 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tran = null;
		tran = session.beginTransaction();
		
		SimpleBook book = new SimpleBook();
		book.setDescription("这是一本好看的书");
		book.setId(Long.valueOf(123));
		book.setName("hibernate333实战3333");
		book.setUrl("http://org.hibernate.org");
		
		session.save(book);
		tran.commit();
	}

}
