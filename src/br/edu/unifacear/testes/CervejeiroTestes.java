package br.edu.unifacear.testes;


import br.edu.unifacear.bo.CervejariaBO;
import br.edu.unifacear.bo.CervejeiroBO;
import br.edu.unifacear.bo.CidadeBO;
import br.edu.unifacear.bo.EnderecoBO;
import br.edu.unifacear.bo.EstadoBO;
import br.edu.unifacear.classes.Cervejaria;
import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.classes.Cidade;
import br.edu.unifacear.classes.Endereco;
import br.edu.unifacear.classes.Estado;

public class CervejeiroTestes {
	
	public static void saveCervejeiro() throws Exception {
		EstadoBO estadobo = new EstadoBO();
		Estado estado = new Estado();
		estado.setNome("Parana");
		estadobo.saveEstado(estado);
		
		Estado estado2 = new Estado();
		estado2.setNome("SaoPaulo");
		estadobo.saveEstado(estado2);
		
		CidadeBO cidadebo = new CidadeBO();
		Cidade cidade = new Cidade();
		cidade.setNome("Araucaria");
		cidade.setEstado(estado);
		cidadebo.saveCidade(cidade);
		
		Cidade cidade2 = new Cidade();
		cidade2.setNome("Rio Preto");
		cidade2.setEstado(estado2);
		cidadebo.saveCidade(cidade2);
		
		EnderecoBO enderecobo = new EnderecoBO();
		Endereco endereco = new Endereco();
		
		endereco.setNome("rua Alberto Filho 552C, Palomar");
		endereco.setCidade(cidade);
		enderecobo.saveEndereco(endereco);
		
		CervejariaBO cervejariabo = new CervejariaBO();
		Cervejaria cervejaria = new Cervejaria();
		
		cervejaria.setNome("irmaos beer");
		cervejaria.setEmail("irmaos@beer.com");
		cervejaria.setTelefone("94839843893");
		cervejaria.setEndereco(endereco);
		cervejariabo.saveCervejaria(cervejaria);
		
		CervejeiroBO cervejeirobo = new CervejeiroBO();
		Cervejeiro cervejeiro = new Cervejeiro();
		
		cervejeiro.setEmail("2@2.com");
		cervejeiro.setSenha("2");
		cervejeiro.setNome("CERVEJEIRO TEST");
		cervejeiro.setIdade(19);
		cervejeiro.setTelefone("999494949");
		cervejeiro.setCervejaria(cervejaria);
		
		cervejeirobo.registerCervejeiro(cervejeiro);
	}
}
