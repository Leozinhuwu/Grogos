package br.edu.unifacear.bo;


import br.edu.unifacear.classes.Sabor;

import br.edu.unifacear.dao.SaborDao;

public class SaborBO {
private static SaborDao  saborCrud = new SaborDao();
	
	public boolean saveSabor(Sabor sabor) throws Exception {
		
		if (saborCrud.autenticarObj(sabor)) {
			return false;

		} else {
			saborCrud.save(sabor);
		}
		return true;
		
	}
}
