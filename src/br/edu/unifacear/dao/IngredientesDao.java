package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Ingredientes;

public class IngredientesDao extends DefaultDAO<Ingredientes> {

	@Override
	protected Query getFindIdQuery(EntityManager con, Ingredientes obj) {

		Query q = con.createQuery("select id from Ingredientes where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;
	}

	@Override
	protected Query getAutenticarObj(EntityManager con, Ingredientes obj) {
		Query q = con.createQuery("select i from Ingredientes i" + " where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;
	}

	@Override
	protected Query getFindName(EntityManager con, Ingredientes obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Ingredientes obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
