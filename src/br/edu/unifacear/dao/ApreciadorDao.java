package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Apreciador;

public class ApreciadorDao extends DefaultDAO<Apreciador> {

	@Override
	protected Query getFindIdQuery(EntityManager con, Apreciador obj) {

		Query q = con.createQuery("select id from Apreciador where email = :email");
		q.setParameter("email", obj.getEmail());
		return q;
	}

	@Override
	protected Query getAutenticarObj(EntityManager con, Apreciador obj) {
		Query q = con.createQuery("select a from Apreciador a" + " where email = :nome" + " and senha = :senha");
		q.setParameter("nome", obj.getEmail());
		q.setParameter("senha", obj.getSenha());
		return q;
	}

	@Override
	protected Query getFindName(EntityManager con, Apreciador obj) {
		Query q = con.createQuery("select nome from Apreciador where email = :email");
		q.setParameter("email", obj.getEmail());
		return q;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Apreciador obj) {
		Query q = con.createQuery("select a from Apreciador a" + " where email = :nome");
		q.setParameter("nome", obj.getEmail());
		return q;
	}

}
