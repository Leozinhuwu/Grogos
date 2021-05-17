package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Cidade;

public class CidadeDao extends DefaultDAO<Cidade> {

	@Override
	protected Query getAutenticarObj(EntityManager con, Cidade obj) {
		// TODO Auto-generated method stub
		return null;
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

}
