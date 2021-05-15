package br.edu.unifacear.testes;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.classes.Usuario;

public class UsuarioTestes {
	
	
	
	public static void saveUsuario() throws Exception {
		ApreciadorBO userbo = new ApreciadorBO();
		Usuario usuario = new Usuario();
		
		usuario.setEmail("1@1.com");
		usuario.setSenha("1");
		usuario.setNome("USUARIO TEST");
		usuario.setIdade(19);
		
		userbo.registerUser(usuario);
	}

}
