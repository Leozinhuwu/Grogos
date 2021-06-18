package br.edu.unifacear.dao;

import javax.persistence.*;

import java.util.List;

import br.edu.unifacear.bd.CBanco;
import br.edu.unifacear.classes.IDBModel;

public abstract class DefaultDAO<T extends IDBModel> {

	protected static EntityManager con = CBanco.getConnection();

	public void save(T obj) throws Exception {

		try {
			con.getTransaction().begin();

			con.persist(obj);

			con.getTransaction().commit();

		} catch (Exception e) {
			throw new Exception("Erro salvando : " + e.getMessage());
		}
	}

	public boolean alterar(T obj) throws Exception {

		try {
			con.getTransaction().begin();

			con.merge(obj);

			con.getTransaction().commit();
			return true;

		} catch (Exception e) {
			throw new Exception("Erro alterando : " + e.getMessage());

		}

	}

	// remove
	public void delete(T obj) throws Exception {

		try {
			con.getTransaction().begin();
			con.remove(obj);
			con.getTransaction().commit();

		} catch (Exception e) {
			throw new Exception("Erro deletando : " + e.getMessage());
		}

	}

	public T findById(Class<T> classe, int id) {
		return con.find(classe, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> list(Class<T> classe) {
		Query q = con.createQuery("select t from " + classe.getSimpleName().toString() + " t");
		return q.getResultList();

	}

	public boolean autenticarObj(T obj) {

		return getAutenticarObj(con, obj).getResultList().size() > 0;
	}

	protected abstract Query getAutenticarObj(EntityManager con, T obj);

	public int findId(T obj) throws Exception {

		@SuppressWarnings("unchecked")
		List<T> a = getFindIdQuery(con, obj).getResultList();
		Object b = a.get(0);
		int id = Integer.parseInt(b.toString());

		return id;
	}

	protected abstract Query getFindIdQuery(EntityManager con, T obj);

	public String findName(T obj) {

		@SuppressWarnings("unchecked")
		List<T> a = getFindName(con, obj).getResultList();
		Object b = a.get(0);
		String name = b.toString();
		return name;
	}

	protected abstract Query getFindName(EntityManager con, T obj);

	public Object findSingleObj(T obj) {
		Object b;
		if (getFindSingleObj(con, obj).getResultList().size() > 0) {
			@SuppressWarnings("unchecked")
			List<T> a = getFindSingleObj(con, obj).getResultList();
			b = a.get(0);
			return b;
		} else {
			return null;
		}

	}

	protected abstract Query getFindSingleObj(EntityManager con, T obj);
}
