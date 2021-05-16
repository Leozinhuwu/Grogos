package br.edu.unifacear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Apreciador;

public class CervejaDao extends DefaultDAO<Cerveja> {

	@Override
	protected Query getFindIdQuery(EntityManager con, Cerveja obj) {

		Query q = con.createQuery("select id from Cerveja where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;
	}

	@Override
	protected Query getAutenticarObj(EntityManager con, Cerveja obj) {
		Query q = con.createQuery("select c from Cerveja c" + " where nome = :nome");
		q.setParameter("nome", obj.getNome());
		return q;
	}

	@Override
	protected Query getFindName(EntityManager con, Cerveja obj) {
		
		return null;
	}
	
	public List<Cerveja> findCerveja(Apreciador user) {
		Query q = con.createQuery("select c from Cerveja c" +
				" where usuario_id = :id");
		q.setParameter("id", user.getId());
		List<Cerveja> cervejas = q.getResultList();
		System.out.println(cervejas);
		return cervejas;
	
	}
}
