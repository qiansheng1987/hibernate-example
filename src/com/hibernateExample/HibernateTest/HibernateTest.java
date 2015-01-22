package com.hibernateExample.HibernateTest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernateExample.entity.SimpleBook;
import junit.framework.TestCase;

public class HibernateTest extends TestCase {
	
	Session session = null;
	
	@Override
	protected void setUp() throws Exception {
		//加载采用hibernate.cfg.xml配置文件
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	@Override
	protected void tearDown() throws Exception {
	    // TODO Auto-generated method stub
		try {
	        session.close();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	@Test
	public void testSave() {
		
		Transaction tran = null;
		tran = session.beginTransaction();
		
		SimpleBook book = new SimpleBook();
		book.setDescription("这是一本好看的书");
		book.setId(Long.valueOf(123));
		book.setName("hibernate实战");
		book.setUrl("http://org.hibernate.org");
		
		session.save(book);
		
		tran.commit();
	}
	
	@Test
	public void testSelect() {
		
		String hql = "from SimpleBook where id = 2";
		Query query = session.createQuery(hql);
		SimpleBook book = (SimpleBook)query.list().get(0);
		List list = book.getEmail();
		for (int i = 0; i < list.size(); i++) {
	        System.out.println(list.get(i));
        }
	}
	
}



















