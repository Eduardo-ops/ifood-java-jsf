package br.com.stefanini.stefaninifood.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("StefaniniFood");

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public void close(EntityManager entityManager) {
		entityManager.close();
	}
}
