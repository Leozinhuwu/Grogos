package br.edu.unifacear.classes;

import javax.persistence.*;

@Entity
public class Cervejaria implements IDBModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String email;
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;

	public Cervejaria(int id, String email, String telefone, Endereco endereco, String nome) {
		super();
		this.id = id;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.nome = nome;
	}

	public Cervejaria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cervejaria [id=" + id + ", email=" + email + ", telefone=" + telefone
				+ ", endereco=" + endereco + "]";
	}
	
	
	

}
