package com.my.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Client");
	
	
	public static final EntityManager getConnection() {return emf.createEntityManager();}
	
	
	

}
