package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Fermento;

public class FermentoDao extends DefaultDAO<Fermento> {

	@Override
	protected Query getAutenticarObj(EntityManager con, Fermento obj) {
		Query q = con.createQuery("select f from Fermento f" + " where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Fermento obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindName(EntityManager con, Fermento obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Fermento obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
