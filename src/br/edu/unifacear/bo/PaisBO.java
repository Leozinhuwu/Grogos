package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Pais;

import br.edu.unifacear.dao.PaisDao;

public class PaisBO {
	private static PaisDao  paisCrud = new PaisDao();
	
	public boolean savePais(Pais pais) throws Exception {
		
		if (paisCrud.autenticarObj(pais)) {
			return false;

		} else {
			paisCrud.save(pais);
		}
		return true;
		
	}
	
	public List<Pais> paises()throws Exception {
		return paisCrud.list(Pais.class);
	}
}
