package br.edu.unifacear.classes;

import javax.persistence.*;

@Entity
public class Usuario implements IDBModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String senha;
	private int idade;
	private String email;
	
//	@ManyToMany
//	@JoinColumn(name="tipocerveja_id")
//	private TipoCerveja tipoCerveja;

	// constructors
	public Usuario(int id, String nome, String senha, int idade, String email) {
		super();
		this.setId(id);
		this.nome = nome;
		this.senha = senha;
		this.idade = idade;
		this.email = email;
	}

	public Usuario() {

	}

	// get and setters
	@Override
	public int getId() {
		System.out.println(id);
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// hash
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario nome = " + nome + ", idade = " + idade + ", email = " + email;
	}

}
