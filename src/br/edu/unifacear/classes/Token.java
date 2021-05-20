package br.edu.unifacear.classes;

import javax.persistence.*;

@Entity
public class Token implements IDBModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String status;
	
	
	
	public Token(int id, String nome, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.status = status;
	}

	public Token() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", nome=" + nome + ", status=" + status + "]";
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
