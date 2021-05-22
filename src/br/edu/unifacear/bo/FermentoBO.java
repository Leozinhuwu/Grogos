package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Fermento;
import br.edu.unifacear.dao.FermentoDao;


public class FermentoBO {
private static FermentoDao  fermentoCrud = new FermentoDao();
	
	public boolean saveFermento(Fermento fermento) throws Exception {
		
		if (fermentoCrud.autenticarObj(fermento)) {
			return false;

		} else {
			fermentoCrud.save(fermento);
		}
		return true;
		
	}
	
	public List<Fermento> fermentos()throws Exception {
		return fermentoCrud.list(Fermento.class);
	}
}
