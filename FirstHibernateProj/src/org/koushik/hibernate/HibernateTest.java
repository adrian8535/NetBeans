package org.koushik.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.Address;
import org.koushik.javabrains.dto.UserDetails;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUsername("First user");
		
		Address addr = new Address();
		addr.setCity("Szn");
		addr.setStreet("Kras");
		
		user.setAddress(addr);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
	    session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User name retrieved : " + user.getUsername());
		
	}

}
