package com.my.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.my.entitys.Client;
import com.my.entitys.Login;
import com.my.factory.ConnectionFactory;
import com.my.services.Criptografar;

public class LoginDAO {
	
	static EntityManager em = ConnectionFactory.getConnection();

	public boolean exitesUsuario(Login login) {
		
		EntityManager em = ConnectionFactory.getConnection();
		List retornoLogin = em.createQuery("select l from Login l where usuario = :usuario and senha = :senha")
				.setParameter("usuario", login.getUsuario()).setParameter("senha", login.getSenha()).getResultList();
		if(login.getUsuario() != null && login.getSenha().equals(Criptografar.encriptografar(login.getSenha()))&& retornoLogin != null && retornoLogin.size()>0) {
			
			return true;
		}else {
			return false;
		}
		
	}

	public static Login save(Login login) {
		em.getTransaction().begin();
		try {
			if (login.getId() == null) {

				em.persist(login);
			} else {
				em.merge(login);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return login;
	}

	public Login findById(Login id) {
				Login login = null;

		try {
			login = em.find(Login.class, id);

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return login;
	}

	public List<Login> findAll() {
		
		List<Login> list = null;

		try {
			list = em.createQuery("from Login").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return list;
	}

	public Login remove(Login id) {
		
		Login login = null;
		try {
			login = em.find(Login.class, id);
			em.getTransaction().begin();
			em.persist(login);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return login;
	}

}
