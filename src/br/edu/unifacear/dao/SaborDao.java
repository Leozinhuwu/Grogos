package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Sabor;

public class SaborDao extends DefaultDAO<Sabor> {

	@Override
	protected Query getAutenticarObj(EntityManager con, Sabor obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Sabor obj) {
		Query q = con.createQuery("select id from Sabor where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;
	}

	@Override
	protected Query getFindName(EntityManager con, Sabor obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Sabor obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
