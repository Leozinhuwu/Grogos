package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.dao.CervejaDao;
import br.edu.unifacear.dao.IngredientesDao;
import br.edu.unifacear.dao.ApreciadorDao;

public class CervejaBO {

	private CervejaDao cervejaDao = new CervejaDao();
	private IngredientesDao ingredientesDao = new IngredientesDao();
	private ApreciadorDao usuarioDao = new ApreciadorDao();

	public boolean salvar(Cerveja cerveja) throws Exception {

		if (cervejaDao.autenticarObj(cerveja)) {
			return false;
		} else {
			cerveja.getIngredientes().setId(ingredientesDao.findId(cerveja.getIngredientes()));
			cerveja.getUsuario().setId(usuarioDao.findId(cerveja.getUsuario()));
			cervejaDao.save(cerveja);
		}
		return true;
	}

	public List findByUser(Usuario user) throws Exception {
		user.setId(usuarioDao.findId(user));
		
		return cervejaDao.findCerveja(user);
	}

}
