package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Ingredientes;
import br.edu.unifacear.dao.IngredientesDao;

public class IngredientesBO {

	IngredientesDao ingredientesDao = new IngredientesDao();

	public boolean salvar(Ingredientes ingredientes) throws Exception {

		if (ingredientesDao.autenticarObj(ingredientes)) {
			return false;
		} else {
			ingredientesDao.save(ingredientes);
		}

		return true;

	}

}
