package br.edu.unifacear.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.classes.TipoCerveja;

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

	public List<Cerveja> findCerveja(Cervejeiro user) {
		Query q = con.createQuery("select c from Cerveja c" + " where cervejeiro_id = :id");
		q.setParameter("id", user.getId());
		@SuppressWarnings("unchecked")
		List<Cerveja> cervejas = q.getResultList();
		return cervejas;

	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Cerveja obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cerveja> pesquisar(String nome, String tipo, String sabor, String coloracao, String pais) {
		String querry = " ";
		if (nome != null) {
			querry = querry + "nome like " + "'%" + nome + "%'";
		}

		if (tipo != null) {
			if (querry == " ") {
				querry = querry + "tipocerveja_id = " + tipo;
			} else {
				querry = querry + " or " + "tipocerveja_id = " + tipo;
			}
		}

		if (sabor != null) {
			if (querry == " ") {
				querry = querry + "sabor_id = " + sabor;
			} else {
				querry = querry + " or " + "sabor_id = " + sabor;
			}
		}

		if (coloracao != null) {
			if (querry == " ") {
				querry = querry + "coloracao_id = " + coloracao;
			} else {
				querry = querry + " or " + "coloracao_id = " + coloracao;
			}
		}

		if (pais != null) {
			if (querry == " ") {
				querry = querry + "pais_id = " + pais;
			} else {
				querry = querry + " or " + "pais_id = " + pais;
			}
		}
		Query q = con.createQuery("select c from Cerveja c" + " where" + querry);

		@SuppressWarnings("unchecked")
		List<Cerveja> cervejas = q.getResultList();
		return cervejas;

	}

	public Cerveja findByName(String nome) {
		Query q = con.createQuery("select c from Cerveja c" + " where nome = :nome");
		q.setParameter("nome", nome);
		@SuppressWarnings("unchecked")
		List<Cerveja> a = q.getResultList();
		Object b = a.get(0);
		return (Cerveja) b;

	}

	@SuppressWarnings("unchecked")
	public List<Cerveja> getLikedCervejas(List<TipoCerveja> tipoCervejas) {
		List<Cerveja> cervejas = new ArrayList<Cerveja>();

		for (TipoCerveja tc : tipoCervejas) {
			Query q = con.createQuery("select c from Cerveja c" + " where tipocerveja_id = :id");
			q.setParameter("id", tc.getId());
			cervejas.addAll(q.getResultList());
		}
		return cervejas;
	}
}
