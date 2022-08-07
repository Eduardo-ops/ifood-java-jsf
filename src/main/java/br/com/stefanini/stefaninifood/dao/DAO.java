package br.com.stefanini.stefaninifood.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> {

	private final Class<T> classe;

	public DAO(Class<T> classe) {
		this.classe = classe;
	}

	public void adiciona(T t) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void remove(T t) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(t));
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void atualiza(T t) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(t);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<T> listaTodos() {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = entityManager.createQuery(query).getResultList();
		entityManager.close();
		return lista;
	}

	public T bucaPorId(Integer id) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		T instancia = entityManager.find(classe, id);
		entityManager.close();
		return instancia;
	}

	public int contaTodos() {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		long result = (Long) entityManager.createQuery("selec count(n) from livro n").getSingleResult();
		entityManager.close();
		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = entityManager.createQuery(query).setFirstResult(firstResult).setFirstResult(maxResults)
				.getResultList();

		entityManager.close();
		return lista;
	}
}
