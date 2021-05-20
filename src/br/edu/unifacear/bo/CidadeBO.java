package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Cidade;
import br.edu.unifacear.classes.Estado;
import br.edu.unifacear.dao.CidadeDao;

public class CidadeBO {
	private static CidadeDao cidadeCrud = new CidadeDao();

	public Boolean saveCidade(Cidade cidade) throws Exception {
		
		if (cidadeCrud.autenticarObj(cidade)) {
			return false;

		} else {
			cidadeCrud.save(cidade);
		}
		return true;

	}

	public List<Cidade> cidades(Estado estado) throws Exception {
		// TODO Auto-generated method stub
		return cidadeCrud.listByEstado(estado);
	}
}
