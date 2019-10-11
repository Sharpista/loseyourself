 	package com.my.dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.Id;

import com.my.entitys.Client;
import com.my.factory.ConnectionFactory;

public class ClientDAO {

	static EntityManager em = ConnectionFactory.getConnection();

	public static Client save(Client client) {
		try {
			em.getTransaction().begin();
			if (client.getId() == null) {
				em.persist(client);
			} else {
				em.merge(client);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return client;
	}

	public Client findById(int id) {
		Client client = null;
		EntityManager em = ConnectionFactory.getConnection();
		try {
			client = em.find(Client.class, id);

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return client;
		
	}

	public List<Client> findAll() {
		EntityManager em = ConnectionFactory.getConnection();
		List<Client> list = null;

		try {
			list = em.createQuery("from Client").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return list;
	}

	public void remove(int id) {
		EntityManager em = ConnectionFactory.getConnection();
		Client client = null;
		try {
			client = em.find(Client.class, id);
			em.getTransaction().begin();
			em.remove(client);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		//return client;
	}
	public Boolean alterar(Client client) {
		Boolean retorno;
		try {
			em.getTransaction().begin();
			em.merge(client);
			em.getTransaction().commit();
			retorno = true;
		} catch (RuntimeException e) {
			em.getTransaction().rollback();
			retorno = false;
			throw e;
		} finally {
			// em.close();
		}
		return retorno;
	}


	
	
	
	

}
