package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Malte;
import br.edu.unifacear.dao.MalteDao;

public class MalteBO {
	private static MalteDao malteCrud = new MalteDao();

	public boolean saveMalte(Malte malte) throws Exception {

		if (malteCrud.autenticarObj(malte)) {
			return false;

		} else {
			malteCrud.save(malte);
		}
		return true;

	}

	public List<Malte> maltes() throws Exception {
		return malteCrud.list(Malte.class);
	}
}
