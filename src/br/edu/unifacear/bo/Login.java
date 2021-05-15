package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.dao.ApreciadorDao;

public class Login {

	private static ApreciadorDao userCrud = new ApreciadorDao();

	public boolean login(Usuario user) {

		boolean auth = userCrud.autenticarObj(user);
		return auth;
	}

}
