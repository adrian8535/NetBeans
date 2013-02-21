package org.koushik.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
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
		

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String minUserId = "5";
		String userName = "User 10";
		
		Query query = session.createQuery("from UserDetails where userid > :userId and userName = :userName");
		query.setInteger(0, Integer.parseInt(minUserId));
		query.setString(1, userName);
		List<UserDetails> users = (List<UserDetails>) query.list();
		
		
		session.getTransaction().commit();
		session.close();
  
		for (UserDetails u: users) {
			System.out.println(u.getUsername());
		}
	}

}
