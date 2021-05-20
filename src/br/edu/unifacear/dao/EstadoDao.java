package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Estado;

public class EstadoDao extends DefaultDAO<Estado>{

	@Override
	protected Query getAutenticarObj(EntityManager con, Estado obj) {
		Query q = con.createQuery("select e from Estado e" + " where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;
		
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Estado obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindName(EntityManager con, Estado obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Estado obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
