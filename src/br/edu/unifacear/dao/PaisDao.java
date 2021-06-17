package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Pais;

public class PaisDao extends DefaultDAO<Pais> {

	@Override
	protected Query getAutenticarObj(EntityManager con, Pais obj) {
		Query q = con.createQuery("select p from Pais p" + " where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Pais obj) {

		Query q = con.createQuery("select id from Pais where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;

	}

	@Override
	protected Query getFindName(EntityManager con, Pais obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Pais obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
