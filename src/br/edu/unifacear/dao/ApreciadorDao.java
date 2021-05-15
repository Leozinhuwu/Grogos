package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Usuario;

public class ApreciadorDao extends DefaultDAO<Usuario> {

	@Override
	protected Query getFindIdQuery(EntityManager con, Usuario obj) {

		Query q = con.createQuery("select id from Usuario where email = :email");
		q.setParameter("email", obj.getEmail());
		return q;
	}

	@Override
	protected Query getAutenticarObj(EntityManager con, Usuario obj) {
		Query q = con.createQuery("select u from Usuario u" + " where email = :nome" + " and senha = :senha");
		q.setParameter("nome", obj.getEmail());
		q.setParameter("senha", obj.getSenha());
		return q;
	}

	@Override
	protected Query getFindName(EntityManager con, Usuario obj) {
		Query q = con.createQuery("select nome from Usuario where email = :email");
		q.setParameter("email", obj.getEmail());
		return q;
	}

}
