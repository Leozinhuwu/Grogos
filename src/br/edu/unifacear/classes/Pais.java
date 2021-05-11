package br.edu.unifacear.classes;

import javax.persistence.*;

@Entity
public class Pais implements IDBModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;

	public Pais(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Pais() {
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
		return "Pais [id=" + id + ", nome=" + nome + "]";
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
