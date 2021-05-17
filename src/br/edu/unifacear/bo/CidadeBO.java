package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Cidade;
import br.edu.unifacear.dao.CidadeDao;

public class CidadeBO {
	private static CidadeDao cidadeCrud = new CidadeDao();

	public void saveCidade(Cidade cidade) throws Exception {

		cidadeCrud.save(cidade);
	}
}
