package br.edu.unifacear.bo;

import br.edu.unifacear.classes.Coloracao;
import br.edu.unifacear.dao.ColoracaoDao;


public class ColoracaoBO {
private static ColoracaoDao  coloracaoCrud = new ColoracaoDao();
	
	public boolean saveColoracao(Coloracao coloracao) throws Exception {
		
		if (coloracaoCrud.autenticarObj(coloracao)) {
			return false;

		} else {
			coloracaoCrud.save(coloracao);
		}
		return true;
		
	}
}
