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

	// remove
	public void delete(Class<T> classe, int id) throws Exception {
		T t = findById(classe, id);
		if (t == null) {
			System.out.println("ta nulo essa merda");
		} else {
			try {
				con.getTransaction().begin();
				con.remove(t);
				con.getTransaction().commit();

			} catch (Exception e) {
				throw new Exception("Erro deletando : " + e.getMessage());
			}
		}

	}

	public T findById(Class<T> classe, int id) {
		return con.find(classe, id);
	}

	public List<T> list(Class<T> classe) {
		Query q = con.createQuery("select t from " + classe.getSimpleName().toString() + " t");
		return q.getResultList();
	}

	public boolean autenticarObj(T obj) {
		return getAutenticarObj(con, obj).getResultList().size() > 0;
	}

	protected abstract Query getAutenticarObj(EntityManager con, T obj);

	public int findId(T obj) throws Exception {

		List a = getFindIdQuery(con, obj).getResultList();
		Object b = a.get(0);
		int id = Integer.parseInt(b.toString());

		return id;
	}

	protected abstract Query getFindIdQuery(EntityManager con, T obj);
	
	public String findName(T obj) {
		
		List a = getFindName(con, obj).getResultList();
		Object b = a.get(0);
		String name = b.toString();
		return name;
	}
	protected abstract Query getFindName(EntityManager con, T obj);
}
