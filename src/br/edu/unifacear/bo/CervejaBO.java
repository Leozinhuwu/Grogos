package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.dao.CervejaDao;
import br.edu.unifacear.dao.CervejeiroDao;
import br.edu.unifacear.dao.IngredientesDao;
import br.edu.unifacear.dao.ApreciadorDao;

public class CervejaBO {

	private CervejaDao cervejaDao = new CervejaDao();
	private IngredientesDao ingredientesDao = new IngredientesDao();
	private CervejeiroDao usuarioDao = new CervejeiroDao();

	public boolean salvar(Cerveja cerveja) throws Exception {

		if (cervejaDao.autenticarObj(cerveja)) {
			return false;
		} else {
			cerveja.getIngredientes().setId(ingredientesDao.findId(cerveja.getIngredientes()));

			cervejaDao.save(cerveja);
		}
		return true;
	}

	public List<Cerveja> findByUser(Cervejeiro user) throws Exception {
	
		
		return cervejaDao.findCerveja(user);
	}

	public void deletar(Cerveja c) throws Exception {
		cervejaDao.delete(c);	
	}

}
