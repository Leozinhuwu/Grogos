package br.edu.unifacear.testes;

import br.edu.unifacear.bo.CervejaBO;
import br.edu.unifacear.bo.CervejeiroBO;
import br.edu.unifacear.bo.ColoracaoBO;
import br.edu.unifacear.bo.FermentoBO;
import br.edu.unifacear.bo.IngredientesBO;
import br.edu.unifacear.bo.LupuloBO;
import br.edu.unifacear.bo.MalteBO;
import br.edu.unifacear.bo.PaisBO;
import br.edu.unifacear.bo.SaborBO;
import br.edu.unifacear.bo.TipoCervejaBO;
import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.classes.Coloracao;
import br.edu.unifacear.classes.Fermento;
import br.edu.unifacear.classes.Ingredientes;
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
		cerveja.setNome("Cerveja bacana");
		Ingredientes ingre1 = new Ingredientes();
		ingre1.setAlcool(true);
		ingre1.setCevada(20);
		ingre1.setFermento(fermento2);
		ingre1.setNome(cerveja.getNome());
		ingre1.setLupulo(lupulo2);
		ingre1.setMalte(malte2);
		ingre1.setPuroMalte(true);
		ingre1.setTeorAlcoolico(2);
		ingre1.setEspeciarias("Essa cerveja contém madeira de carvalho torrado");
		
		IngredientesBO ingbro = new IngredientesBO();
		ingbro.salvar(ingre1);
		
		cerveja.setIngredientes(ingre1);
		
		Cervejeiro cervejeiro = new Cervejeiro();
		cervejeiro.setId(1);
		
		CervejeiroBO cerbo = new CervejeiroBO();
		cerveja.setCervejeiro((Cervejeiro) cerbo.findById(cervejeiro));
		
		cerveja.setColoracao(coloracao2);
		cerveja.setCountryOrigin(pais2);
		cerveja.setDescription("Essa Ceveja tem um sabor levemente amargo e uma coloração escura");
		cerveja.setFlavor(sabor2);
		cerveja.setType(tipocerveja2);
		
		CervejaBO cbo = new CervejaBO();
		cbo.salvar(cerveja);
		
		
		Cerveja cerveja2 = new Cerveja();
		cerveja2.setNome("Cerveja Allie 3");
		Ingredientes ingre2 = new Ingredientes();
		ingre2.setAlcool(true);
		ingre2.setCevada(20);
		ingre2.setFermento(fermento2);
		ingre2.setNome(cerveja2.getNome());
		ingre2.setLupulo(lupulo2);
		ingre2.setMalte(malte2);
		ingre2.setPuroMalte(true);
		ingre2.setTeorAlcoolico(2);
		ingre2.setEspeciarias("Essa cerveja contém cogumelos");
		

		ingbro.salvar(ingre2);
		
		cerveja2.setIngredientes(ingre2);
		
		cerveja2.setCervejeiro((Cervejeiro) cerbo.findById(cervejeiro));
		
		cerveja2.setColoracao(coloracao2);
		cerveja2.setCountryOrigin(pais2);
		cerveja2.setDescription("Essa Ceveja foi feita com amor!");
		cerveja2.setFlavor(sabor2);
		cerveja2.setType(tipocerveja2);

		cbo.salvar(cerveja2);
		
		Cerveja cerveja3 = new Cerveja();
		cerveja3.setNome("Cerveja Allie 2");
		Ingredientes ingre3 = new Ingredientes();
		ingre3.setAlcool(true);
		ingre3.setCevada(20);
		ingre3.setFermento(fermento2);
		ingre3.setNome(cerveja2.getNome());
		ingre3.setLupulo(lupulo2);
		ingre3.setMalte(malte2);
		ingre3.setPuroMalte(true);
		ingre3.setTeorAlcoolico(2);
		ingre3.setEspeciarias("Essa cerveja contém peixe");
		

		ingbro.salvar(ingre3);
		
		cerveja3.setIngredientes(ingre3);
		
		cerveja3.setCervejeiro((Cervejeiro) cerbo.findById(cervejeiro));
		
		cerveja3.setColoracao(coloracao2);
		cerveja3.setCountryOrigin(pais2);
		cerveja3.setDescription("Essa Ceveja foi feita com amor e carinho!");
		cerveja3.setFlavor(sabor2);
		cerveja3.setType(tipocerveja2);

		cbo.salvar(cerveja3);
		
		Cerveja cerveja4 = new Cerveja();
		cerveja4.setNome("Cerveja Skill Set");
		Ingredientes ingre4 = new Ingredientes();
		ingre4.setAlcool(true);
		ingre4.setCevada(20);
		ingre4.setFermento(fermento2);
		ingre4.setNome(cerveja2.getNome());
		ingre4.setLupulo(lupulo2);
		ingre4.setMalte(malte2);
		ingre4.setPuroMalte(true);
		ingre4.setTeorAlcoolico(2);
		ingre4.setEspeciarias("Essa cerveja monster");
		

		ingbro.salvar(ingre4);
		
		cerveja4.setIngredientes(ingre4);
		
		cerveja4.setCervejeiro((Cervejeiro) cerbo.findById(cervejeiro));
		
		cerveja4.setColoracao(coloracao2);
		cerveja4.setCountryOrigin(pais2);
		cerveja4.setDescription("Essa Ceveja da energia");
		cerveja4.setFlavor(sabor2);
		cerveja4.setType(tipocerveja2);

		cbo.salvar(cerveja4);

	}
}
