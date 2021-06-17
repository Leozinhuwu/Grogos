package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Sabor;
import br.edu.unifacear.dao.SaborDao;

public class SaborBO {
	private static SaborDao saborCrud = new SaborDao();

	public boolean saveSabor(Sabor sabor) throws Exception {

		if (saborCrud.autenticarObj(sabor)) {
			return false;

		} else {
			saborCrud.save(sabor);
		}
		return true;

	}

	public List<Sabor> sabores() throws Exception {
		return saborCrud.list(Sabor.class);
	}
}
