package br.edu.unifacear.bo;

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
	
}
