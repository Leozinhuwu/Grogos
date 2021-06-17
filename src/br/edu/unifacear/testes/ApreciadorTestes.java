package br.edu.unifacear.testes;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.classes.TipoCerveja;

public class ApreciadorTestes {

	public static void saveUsuario() throws Exception {
		ApreciadorBO userbo = new ApreciadorBO();
		Apreciador usuario = new Apreciador();
		TipoCerveja tipo1 = new TipoCerveja();
		tipo1.setId(2);
		tipo1.setNome("Barbarea");

		usuario.setEmail("1@1.com");
		usuario.setSenha("1");
		usuario.setNome("USUARIO TEST");
		usuario.setIdade(19);
		userbo.registerUser(usuario);

		usuario.addTipoCerveja(tipo1);
		userbo.alterar(usuario);

		Apreciador apre = new Apreciador();
		apre.setEmail("1@1.com");

		apre = (Apreciador) userbo.findApreciador(apre);

	}

}
