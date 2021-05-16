package br.edu.unifacear.classes;

import javax.persistence.*;

@Entity
public class Endereco implements IDBModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cidade_id")
	private Cidade cidade;
	private String nome;
	
	public Endereco(int id, Cidade cidade, String nome) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.nome = nome;
	}

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cidade=" + cidade + ", nome=" + nome + "]";
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
