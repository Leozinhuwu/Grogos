package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Malte;

public class MalteDao extends DefaultDAO<Malte> {

	@Override
	protected Query getAutenticarObj(EntityManager con, Malte obj) {
		Query q = con.createQuery("select m from Malte m" + " where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Malte obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindName(EntityManager con, Malte obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Malte obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
