package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.dao.UsuarioDao;

public class Login {

	private static UsuarioDao userCrud = new UsuarioDao();

	public boolean login(Usuario user) {

		boolean auth = userCrud.autenticarObj(user);
		return auth;
	}

}
