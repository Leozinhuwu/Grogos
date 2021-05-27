package br.edu.unifacear.bo;


import br.edu.unifacear.classes.Token;
import br.edu.unifacear.dao.TokenDao;

public class TokenBO {
	private static TokenDao tokenCrud = new TokenDao();
	
	public void salvar(Token tokenc) throws Exception {
		
		tokenCrud.save(tokenc);
		
	}
	
	public Object findToken(Token token) {
		
		return tokenCrud.findSingleObj(token);
	}

	public void alterar(Token token) throws Exception {
		tokenCrud.alterar(token);
		
	}

}
