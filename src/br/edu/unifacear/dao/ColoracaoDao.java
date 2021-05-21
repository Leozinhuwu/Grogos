package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Coloracao;


public class ColoracaoDao extends DefaultDAO<Coloracao> {

	@Override
	protected Query getAutenticarObj(EntityManager con, Coloracao obj) {
		Query q = con.createQuery("select c from Coloracao c" + " where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Coloracao obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindName(EntityManager con, Coloracao obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Coloracao obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
