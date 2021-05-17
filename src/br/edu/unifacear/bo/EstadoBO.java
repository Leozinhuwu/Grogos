package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Estado;
import br.edu.unifacear.dao.EstadoDao;

public class EstadoBO {
	private static EstadoDao estadoCrud = new EstadoDao();

	public void saveEstado(Estado estado) throws Exception {

		estadoCrud.save(estado);
	}
}
