package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.dao.ApreciadorDao;
import br.edu.unifacear.dao.CervejeiroDao;

public class CervejeiroBO {
	private static CervejeiroDao cervejeiroCrud = new CervejeiroDao();
	
	public void registerCervejeiro(Cervejeiro usuario) throws Exception {
	
		cervejeiroCrud.save(usuario);
	}

}
