package br.edu.unifacear.bo;


import br.edu.unifacear.classes.Endereco;
import br.edu.unifacear.dao.EnderecoDao;

public class EnderecoBO {
	private static EnderecoDao enderecoCrud = new EnderecoDao();

	public void saveEndereco(Endereco endereco) throws Exception {

		enderecoCrud.save(endereco);
	}
}