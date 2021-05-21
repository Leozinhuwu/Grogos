package br.edu.unifacear.main;




import br.edu.unifacear.bd.CBanco;
import br.edu.unifacear.telas.*;
import br.edu.unifacear.testes.ApreciadorTestes;
import br.edu.unifacear.testes.CervejaTestes;
import br.edu.unifacear.testes.CervejeiroTestes;

public class Main {

	public static void main(String[] args) throws Exception {
		CBanco.getConnection();
		CervejeiroTestes.saveCervejeiro();
		ApreciadorTestes.saveUsuario();
		CervejaTestes.saveCerveja();
		//TelaCadastroApreciador.telaCadastro();
		//TelaCadastroCervejeiro.telaCadastro();
		TelaLogin.telaInicial();
		//TelaCadastroCerveja.telaCadastro();
		TelaAdm.telaAdm();
		

	}

}
