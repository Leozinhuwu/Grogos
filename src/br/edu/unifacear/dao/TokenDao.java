package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.TipoCerveja;
import br.edu.unifacear.classes.Token;

public class TokenDao extends DefaultDAO<Token> {

	@Override
	protected Query getAutenticarObj(EntityManager con, Token obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Token obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindName(EntityManager con, Token obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Token obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
