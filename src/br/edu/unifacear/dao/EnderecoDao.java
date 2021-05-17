package br.edu.unifacear.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.classes.Endereco;

public class EnderecoDao extends DefaultDAO<Endereco> {

	@Override
	protected Query getAutenticarObj(EntityManager con, Endereco obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindIdQuery(EntityManager con, Endereco obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindName(EntityManager con, Endereco obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Query getFindSingleObj(EntityManager con, Endereco obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
