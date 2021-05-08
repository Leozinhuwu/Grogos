package br.edu.unifacear.main;




import br.edu.unifacear.bd.CBanco;
import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.telas.*;
import br.edu.unifacear.testes.UsuarioTestes;

public class Main {

	public static void main(String[] args) throws Exception {
	

		UsuarioTestes.saveUsuario();
		CBanco.getConnection();
		
		TelaInicial.telaInicial();
		//TelaCadastroCerveja.telaCadastro();

	}

}
