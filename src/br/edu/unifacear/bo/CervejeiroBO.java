package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.dao.CervejeiroDao;

public class CervejeiroBO {
	private static CervejeiroDao cervejeiroCrud = new CervejeiroDao();

	public Boolean registerCervejeiro(Cervejeiro cervejeiro) throws Exception {
		if (cervejeiroCrud.autenticarObj(cervejeiro)) {
			return false;

		} else {
			cervejeiroCrud.save(cervejeiro);
		}
		return true;

	}

	public String findUserName(Cervejeiro user) throws Exception {
		String name = cervejeiroCrud.findName(user);
		return name;
	}

	public Object findCervejeiro(Cervejeiro cervejeiro) {

		return cervejeiroCrud.findSingleObj(cervejeiro);
	}

	public void deletar(Cervejeiro cervejeiro) throws Exception {
		cervejeiroCrud.delete(cervejeiro);

	}

	public boolean login(Cervejeiro usercer) {
		if (cervejeiroCrud.autenticarObj(usercer)) {
			return true;
		}
		return false;
	}

	public boolean alterar(Cervejeiro novocerv) throws Exception {

		if (!cervejeiroCrud.alterar(novocerv)) {
			return false;
		}
		return true;
	}
	
	public Cervejeiro findById(Cervejeiro cervejeiro) throws Exception{
		return cervejeiroCrud.findById(Cervejeiro.class, cervejeiro.getId());
	}

}
