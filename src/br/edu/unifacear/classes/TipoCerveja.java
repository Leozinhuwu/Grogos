package br.edu.unifacear.classes;

import java.util.List;

import javax.persistence.*;

@Entity
public class TipoCerveja implements IDBModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String nome;
	
	


	public TipoCerveja(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}


	public TipoCerveja() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public String toString() {
		return  nome;
	}


	@Override
	public String getEmail() {
		return null;
	}
	
	
}
