package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Estado;
import br.edu.unifacear.dao.EstadoDao;

public class EstadoBO {
	private static EstadoDao estadoCrud = new EstadoDao();

	public Boolean saveEstado(Estado estado) throws Exception {

		if (estadoCrud.autenticarObj(estado)) {
			return false;

		} else {
			estadoCrud.save(estado);
		}
		return true;
	}

	public List<Estado> estados() throws Exception {
		return estadoCrud.list(Estado.class);

	}
}
