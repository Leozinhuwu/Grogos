package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Token;
import br.edu.unifacear.dao.TokenDao;

public class TokenBO {
	
	public void salvar(Token tokenc) throws Exception {
		TokenDao tokendao = new TokenDao();
		
		tokendao.save(tokenc);
		
	}

}
