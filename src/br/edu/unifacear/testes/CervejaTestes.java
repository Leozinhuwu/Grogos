package br.edu.unifacear.testes;

import br.edu.unifacear.bo.ColoracaoBO;
import br.edu.unifacear.bo.FermentoBO;
import br.edu.unifacear.bo.LupuloBO;
import br.edu.unifacear.bo.MalteBO;
import br.edu.unifacear.bo.PaisBO;
import br.edu.unifacear.bo.SaborBO;
import br.edu.unifacear.bo.TipoCervejaBO;
import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Coloracao;
import br.edu.unifacear.classes.Fermento;
import br.edu.unifacear.classes.Lupulo;
import br.edu.unifacear.classes.Malte;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Sabor;
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
		
		PaisBO paisbo = new PaisBO();
		Pais pais1 = new Pais();
		pais1.setNome("Brasil");
		paisbo.savePais(pais1);
		
		Pais pais2 = new Pais();
		pais2.setNome("Estado Unidos");
		paisbo.savePais(pais2);
		
		SaborBO saborbo = new SaborBO();
		Sabor sabor1 = new Sabor();
		sabor1.setNome("Muito Amargo");
		saborbo.saveSabor(sabor1);
		
		Sabor sabor2 = new Sabor();
		sabor2.setNome("Leve Amargo");
		saborbo.saveSabor(sabor2);
		
		ColoracaoBO colobo = new ColoracaoBO();
		Coloracao coloracao1 = new Coloracao();
		coloracao1.setNome("Dourada");
		colobo.saveColoracao(coloracao1);
		
		Coloracao coloracao2 = new Coloracao();
		coloracao2.setNome("Escura");
		colobo.saveColoracao(coloracao2);
		
		MalteBO maltebo = new MalteBO();
		Malte malte = new  Malte();
		malte.setNome("Pale Ale");
		maltebo.saveMalte(malte);
		
		Malte malte2 = new  Malte();
		malte2.setNome("Centeio, Trigo e Aveia");
		maltebo.saveMalte(malte2);
		
		LupuloBO lupulobo = new LupuloBO();
		Lupulo lupulo = new Lupulo();
		lupulo.setNome("Mantiqueira");
		lupulobo.saveLupulo(lupulo);
		
		Lupulo lupulo2 = new Lupulo();
		lupulo2.setNome("Saaz");
		lupulobo.saveLupulo(lupulo2);
		
		FermentoBO fermentobo = new FermentoBO();
		Fermento fermento = new Fermento();
		fermento.setNome("Fermentis Safale");
		fermentobo.saveFermento(fermento);
		
		Fermento fermento2 = new Fermento();
		fermento2.setNome("Lallemand Diamond Lager");
		fermentobo.saveFermento(fermento2);
		
		
		
		
		Cerveja cerveja = new Cerveja();
	}
}
