package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Apreciador;

import br.edu.unifacear.dao.*;

public class ApreciadorBO {
	private static ApreciadorDao userCrud = new ApreciadorDao();

	public boolean registerUser(Apreciador user) throws Exception {

		if (userCrud.autenticarObj(user)) {
			return false;

		} else {
			userCrud.save(user);
		}
		return true;
	}
	
	public String findUserName(Apreciador user) throws Exception{
		String name = userCrud.findName(user);
		return name;
	}
	
	public Boolean login(Apreciador apreciador) {
		if (userCrud.autenticarObj(apreciador)) {
			return true;
		}
		return false;
		
	}
	public Object findApreciador(Apreciador apreciador) {
		// TODO Auto-generated method stub
		return userCrud.findSingleObj(apreciador);
	}

	public void deletar(Apreciador apre) throws Exception {
		userCrud.delete(apre);
		
	}

}
