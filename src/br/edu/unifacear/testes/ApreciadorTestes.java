package br.edu.unifacear.testes;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.classes.Apreciador;

public class ApreciadorTestes {
	
	
	
	public static void saveUsuario() throws Exception {
		ApreciadorBO userbo = new ApreciadorBO();
		Apreciador usuario = new Apreciador();
		
		usuario.setEmail("1@1.com");
		usuario.setSenha("1");
		usuario.setNome("USUARIO TEST");
		usuario.setIdade(19);
		
		userbo.registerUser(usuario);
	}

}
