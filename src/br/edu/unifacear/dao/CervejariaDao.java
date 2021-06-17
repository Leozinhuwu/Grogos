package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Cervejaria;

public class CervejariaDao extends DefaultDAO<Cervejaria> {

	@Override
	protected Query getAutenticarObj(EntityManager con, Cervejaria obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Cervejaria obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindName(EntityManager con, Cervejaria obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Cervejaria obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
