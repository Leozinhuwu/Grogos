package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Lupulo;


public class LupuloDao extends DefaultDAO<Lupulo> {
	
	@Override
	protected Query getAutenticarObj(EntityManager con, Lupulo obj) {
		Query q = con.createQuery("select l from Lupulo l" + " where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Lupulo obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindName(EntityManager con, Lupulo obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Lupulo obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
