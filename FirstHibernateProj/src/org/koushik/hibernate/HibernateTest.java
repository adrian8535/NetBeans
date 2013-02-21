package org.koushik.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.Address;
import org.koushik.javabrains.dto.FourWheeler;
import org.koushik.javabrains.dto.TwoWheeler;
import org.koushik.javabrains.dto.UserDetails;
import org.koushik.javabrains.dto.Vehicle;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUsername("Test user");
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		user.setUsername("Updated user");
		session.save(user);

		session.getTransaction().commit();
		session.close();

	}

}
