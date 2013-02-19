package org.koushik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.UserDetails;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserId(3);
		user.setUsername("Third user");
		 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
	}

}
