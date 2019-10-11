package com.my.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeradorDeTabela {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Client");
		
		EntityManager em  = emf.createEntityManager();
		
		System.out.println("Criou");
		
		
		emf.close();
		em.close();
		
		

	}

}
