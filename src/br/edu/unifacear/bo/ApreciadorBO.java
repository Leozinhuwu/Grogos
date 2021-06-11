package br.edu.unifacear.bo;



import java.util.List;

import br.edu.unifacear.classes.Apreciador;

import br.edu.unifacear.dao.*;

public class ApreciadorBO {
	private static ApreciadorDao userCrud = new ApreciadorDao();

	public boolean registerUser(Apreciador user) throws Exception {

		if (userCrud.autenticarEmail(user.getEmail())) {
			return false;

		} else {
			userCrud.save(user);
		}
		return true;
	}
	
	public String findUserName(Apreciador user) throws Exception{
		String name = userCrud.findName(user);
		return name;
	}
	
	public Boolean login(Apreciador apreciador) {
		if (userCrud.autenticarObj(apreciador)) {
			return true;
		}
		return false;
		
	}
	public Object findApreciador(Apreciador apreciador) {
		
		return userCrud.findSingleObj(apreciador);
	}

	public void deletar(Apreciador apre) throws Exception {
		userCrud.delete(apre);
		
	}
	
	public boolean autenticarEmail(String email) {
		return userCrud.autenticarEmail(email);
	}
	
	
	public void alterar(Apreciador user) throws Exception {
	
			userCrud.alterar(user);
	
	}

	public List<Apreciador> listar() {
		// TODO Auto-generated method stub
		return userCrud.list(Apreciador.class);
	}

}
