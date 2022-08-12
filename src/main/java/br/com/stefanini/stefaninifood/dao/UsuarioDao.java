package br.com.stefanini.stefaninifood.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.stefanini.stefaninifood.modelo.Usuario;

public class UsuarioDao {

	public boolean existeUsuario(Usuario usuario) {

		EntityManager entityManager = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = entityManager.createQuery("select usuario from usuario"
				+ "where usuario.email = p:parameterEmail and usuario.senha = p:parameterSenha", Usuario.class);

		query.setParameter("parameterEmail", query);
		query.setParameter("parameterSenha", query);

		try {
			Usuario resultado = query.getSingleResult();
		} catch (NoResultException noResultException) {
			return false;
		}

		entityManager.close();

		return true;
	}
}
