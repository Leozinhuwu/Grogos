package br.edu.unifacear.main;




import br.edu.unifacear.bd.CBanco;
import br.edu.unifacear.telas.*;
import br.edu.unifacear.testes.ApreciadorTestes;
import br.edu.unifacear.testes.CervejaTestes;
import br.edu.unifacear.testes.CervejeiroTestes;

public class Main {

	public static void main(String[] args) throws Exception {
		getConnectionAndRunTests();
		runGrogos();
		
	}

	private static void runGrogos() throws Exception {
		TelaLogin telaIanicial = new TelaLogin();
		telaIanicial.telaInicial();
		TelaAdm tAdm = new TelaAdm();
		tAdm.telaAdm();
	}

	private static void getConnectionAndRunTests() throws Exception {
		CBanco.getConnection();
		CervejeiroTestes.saveCervejeiro();
		CervejaTestes.saveCerveja();
		ApreciadorTestes.saveUsuario();
	}

}
