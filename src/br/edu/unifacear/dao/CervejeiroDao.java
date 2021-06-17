package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Cervejeiro;

public class CervejeiroDao extends DefaultDAO<Cervejeiro> {

	@Override
	protected Query getAutenticarObj(EntityManager con, Cervejeiro obj) {
		Query q = con.createQuery("select id from Cervejeiro where email = :email" + " and senha = :senha");
		q.setParameter("email", obj.getEmail());
		q.setParameter("senha", obj.getSenha());
		return q;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Cervejeiro obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindName(EntityManager con, Cervejeiro obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Cervejeiro obj) {
		Query q = con.createQuery("select a from Cervejeiro a" + " where email = :nome");
		q.setParameter("nome", obj.getEmail());
		return q;
	}

	public boolean autenticarEmail(String email) {
		Query q = con.createQuery("select a from Apreciador a" + " where email = :nome");
		q.setParameter("nome", email);

		if (q.getResultList().size() > 0) {
			return true;
		}

		q = con.createQuery("select c from Cervejeiro c" + " where email = :nome");
		q.setParameter("nome", email);
		if (q.getResultList().size() > 0) {
			return true;
		}
		return false;
	}

}
