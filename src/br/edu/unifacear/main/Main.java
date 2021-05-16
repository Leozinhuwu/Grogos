package br.edu.unifacear.main;




import br.edu.unifacear.bd.CBanco;
import br.edu.unifacear.telas.*;
import br.edu.unifacear.testes.ApreciadorTestes;

public class Main {

	public static void main(String[] args) throws Exception {
	
		ApreciadorTestes.saveUsuario();
		CBanco.getConnection();
		TelaLogin.telaInicial();
		//TelaCadastroCerveja.telaCadastro();
		TelaAdm.telaAdm();

	}

}
