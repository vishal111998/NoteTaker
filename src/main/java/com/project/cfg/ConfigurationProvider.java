package com.project.cfg;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConfigurationProvider {

	private static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	private static SessionFactory factory = null;
	
	public static SessionFactory getSessionFactory() {
		try {
			if(factory == null) {
				factory = configuration.buildSessionFactory();
			}
		} catch (Exception e) {
			System.out.println("Exception in ConfigurationProvider.getSessionFactory()");
			e.printStackTrace();
		}
		
		return factory;
	}
}
