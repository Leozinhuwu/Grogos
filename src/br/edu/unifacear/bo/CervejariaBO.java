package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Cervejaria;

import br.edu.unifacear.dao.CervejariaDao;

public class CervejariaBO {
	private static CervejariaDao cervejariaCrud = new CervejariaDao();

	public void saveCervejaria(Cervejaria cerveja) throws Exception {

		cervejariaCrud.save(cerveja);
	}

	public void deletar(Cervejaria cervejaria) throws Exception {
		cervejariaCrud.delete(cervejaria);
	}

	public boolean alterar(Cervejaria cervejaria) throws Exception {
		if(!cervejariaCrud.alterar(cervejaria)) {
			return false;
		}
		return true;
	}


}
