package br.edu.unifacear.testes;


import br.edu.unifacear.bo.CervejeiroBO;
import br.edu.unifacear.classes.Cervejeiro;

public class CervejeiroTestes {
	
	public static void saveCervejeiro() throws Exception {
		CervejeiroBO userbo = new CervejeiroBO();
		Cervejeiro usuario = new Cervejeiro();
		
		usuario.setEmail("1@1.com");
		usuario.setSenha("1");
		usuario.setNome("USUARIO TEST");
		usuario.setIdade(19);
		usuario.setTelefone(999494949);
		userbo.registerCervejeiro(usuario);
	}
}
