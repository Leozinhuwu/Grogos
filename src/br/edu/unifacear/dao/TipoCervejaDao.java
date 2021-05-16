package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.TipoCerveja;

public class TipoCervejaDao extends DefaultDAO<TipoCerveja> {

	@Override
	protected Query getAutenticarObj(EntityManager con, TipoCerveja obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, TipoCerveja obj) {
		Query q = con.createQuery("select id from TipoCerveja where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;
	}

	@Override
	protected Query getFindName(EntityManager con, TipoCerveja obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, TipoCerveja obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
