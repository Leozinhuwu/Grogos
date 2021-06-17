package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Cidade;
import br.edu.unifacear.classes.Estado;

public class CidadeDao extends DefaultDAO<Cidade> {

	@Override
	protected Query getAutenticarObj(EntityManager con, Cidade obj) {
		Query q = con.createQuery("select ci from Cidade ci" + " where nome = :nome" + " and estado_id = :id");
		q.setParameter("nome", obj.getNome());
		q.setParameter("id", obj.getEstado().getId());
		return q;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Cidade obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindName(EntityManager con, Cidade obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Cidade obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cidade> listByEstado(Estado estado) {
		Query q = con.createQuery("select c from Cidade c" + " where estado_id = :id");
		q.setParameter("id", estado.getId());
		return q.getResultList();
	}

}
