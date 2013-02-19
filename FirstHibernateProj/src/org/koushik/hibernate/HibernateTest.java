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
		
		Address addr1 = new Address();
		addr1.setStreet("1st street");
		addr1.setCity("1st city");
		addr1.setState("1st state");
		addr1.setPincode("1001");
		
		Address addr2 = new Address();
		addr2.setStreet("2st street");
		addr2.setCity("2st city");
		addr2.setState("2st state");
		addr2.setPincode("2001");
		
		user.getListOfAddresses().add(addr1);
		user.getListOfAddresses().add(addr2);
		
		
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
