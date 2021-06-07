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

	public void alterar(Cervejeiro novocerv) throws Exception {

		cervejeiroCrud.alterar(novocerv);

	}

	public Cervejeiro findById(Cervejeiro cervejeiro) throws Exception {
		return cervejeiroCrud.findById(Cervejeiro.class, cervejeiro.getId());
	}

	public boolean autenticarEmail(String email) {
		return cervejeiroCrud.autenticarEmail(email);
	}

}
