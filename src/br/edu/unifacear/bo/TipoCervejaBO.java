package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.TipoCerveja;
import br.edu.unifacear.dao.TipoCervejaDao;

public class TipoCervejaBO {
	private static TipoCervejaDao tipoCervejaCrud = new TipoCervejaDao();

	public Boolean saveTipoCerveja(TipoCerveja tipoCerveja) throws Exception {

		if (tipoCervejaCrud.autenticarObj(tipoCerveja)) {
			return false;

		} else {
			tipoCervejaCrud.save(tipoCerveja);
		}
		return true;
	}

	public List<TipoCerveja> tipos() throws Exception {
		return tipoCervejaCrud.list(TipoCerveja.class);

	}

	public TipoCerveja findById(TipoCerveja tipo) {
		return tipoCervejaCrud.findById(TipoCerveja.class, tipo.getId());
	}

	public void alterar(TipoCerveja tipo) throws Exception {
		tipoCervejaCrud.alterar(tipo);

	}
}
