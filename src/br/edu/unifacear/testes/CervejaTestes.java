package br.edu.unifacear.testes;

import br.edu.unifacear.bo.TipoCervejaBO;
import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.TipoCerveja;

public class CervejaTestes {
	
	public static void saveCerveja() throws Exception {
		TipoCerveja tipocerveja = new TipoCerveja();
		TipoCerveja tipocerveja2 = new TipoCerveja();
		TipoCervejaBO tcbo = new TipoCervejaBO();
		tipocerveja.setNome("Pilsen");
		tcbo.saveTipoCerveja(tipocerveja);
		tipocerveja2.setNome("Barbarea");
		tcbo.saveTipoCerveja(tipocerveja2);
		
		Cerveja cerveja = new Cerveja();
	}
}
