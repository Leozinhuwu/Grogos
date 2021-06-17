package br.edu.unifacear.bo;

import java.util.List;

import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.classes.TipoCerveja;
import br.edu.unifacear.dao.CervejaDao;
import br.edu.unifacear.dao.IngredientesDao;

public class CervejaBO {

	private CervejaDao cervejaDao = new CervejaDao();
	private IngredientesDao ingredientesDao = new IngredientesDao();

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

	public Cerveja findById(Cerveja c) {
		return cervejaDao.findById(Cerveja.class, c.getId());
	}

	public List<Cerveja> pesquisaCervejas(String nome, String tipo, String sabor, String coloracao, String pais)
			throws Exception {
		return cervejaDao.pesquisar(nome, tipo, sabor, coloracao, pais);
	}

	public Cerveja findByName(String nome) throws Exception {

		return cervejaDao.findByName(nome);
	}

	public List<Cerveja> findLikedCervejas(List<TipoCerveja> tipoCervejas) {
		List<Cerveja> cervejas = cervejaDao.list(Cerveja.class);
		List<Cerveja> cervejasLiked = cervejaDao.getLikedCervejas(tipoCervejas);
		if (tipoCervejas.isEmpty()) {
			return cervejas;
		}
		cervejasLiked.addAll(cervejas);
		return cervejasLiked;

	}

}
