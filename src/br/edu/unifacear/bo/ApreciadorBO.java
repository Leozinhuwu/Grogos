package br.edu.unifacear.bo;

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

}
