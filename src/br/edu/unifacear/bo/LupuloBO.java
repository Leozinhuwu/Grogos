package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Lupulo;
import br.edu.unifacear.dao.LupuloDao;

public class LupuloBO {
	private static LupuloDao lupuloCrud = new LupuloDao();

	public boolean saveLupulo(Lupulo lupulo) throws Exception {

		if (lupuloCrud.autenticarObj(lupulo)) {
			return false;

		} else {
			lupuloCrud.save(lupulo);
		}
		return true;

	}

	public List<Lupulo> lupulos() throws Exception {
		return lupuloCrud.list(Lupulo.class);
	}

}
