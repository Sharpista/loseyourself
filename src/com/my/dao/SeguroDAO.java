package com.my.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.my.entitys.Client;
import com.my.entitys.Seguro;
import com.my.factory.ConnectionFactory;

import jdk.internal.dynalink.beans.StaticClass;

public class SeguroDAO {

	static EntityManager em = ConnectionFactory.getConnection();

	public static Seguro save(Seguro s) {

		try {
			em.getTransaction().begin();

			if (s.getId_seguro() == null) {
				em.persist(s);
			} else {
				em.merge(s);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return s;

	}

	public Seguro findById(Integer id) {

		EntityManager em = ConnectionFactory.getConnection();
		Seguro seguro = null;

		try {
			seguro = em.find(Seguro.class, id);

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return seguro;
	}

	public List<Seguro> findAll() {
		EntityManager em = ConnectionFactory.getConnection();
		List<Seguro> list = null;

		try {
			list = em.createQuery("from Seguro").getResultList();
			
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}

		return list;
	}

	public Seguro remove(Integer id) {
		EntityManager em = ConnectionFactory.getConnection();
		Seguro seguro = null;
		try {
			seguro = em.find(Seguro.class, id);
			em.getTransaction().begin();
			em.persist(seguro);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return seguro;
	}

}
