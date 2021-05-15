package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Usuario;

import br.edu.unifacear.dao.*;

public class ApreciadorBO {
	private static ApreciadorDao userCrud = new ApreciadorDao();

	public boolean registerUser(Usuario user) throws Exception {

		if (userCrud.autenticarObj(user)) {
			return false;

		} else {
			userCrud.save(user);
		}
		return true;
	}
	
	public String findUserName(Usuario user) throws Exception{
		String name = userCrud.findName(user);
		return name;
	}

}
