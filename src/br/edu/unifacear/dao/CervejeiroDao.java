package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.classes.Cervejeiro;

public class CervejeiroDao extends DefaultDAO<Cervejeiro>{

	@Override
	protected Query getAutenticarObj(EntityManager con, Cervejeiro obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Cervejeiro obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindName(EntityManager con, Cervejeiro obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Cervejeiro obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
