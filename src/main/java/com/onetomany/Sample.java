package com.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Sample {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sf = configuration.buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();
		
		User user = new User();
		Policy policy1 = new Policy("MC", "bike Insurance", "Active", user);
		Policy policy2 = new Policy("AG", "home Insurance", "Active", user);
		
		Set<Policy> set = new HashSet<Policy>();
		set.add(policy1);
		set.add(policy2);
		
		user.setPolicy(set);
		user.setName("Jeevan");
		user.setEmail("jeevan@rediffmail.com");
		
		s.save(user);
		s.save(policy1);
		s.save(policy2);
		
		t.commit();

	}

}

