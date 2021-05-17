package br.edu.unifacear.classes;

import java.util.List;

import javax.persistence.*;

@Entity
public class Cervejeiro implements IDBModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String senha;
	private int idade;
	private String email;
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name="cervejaria_id")
	private Cervejaria cervejaria;
	@ManyToMany
    @JoinTable(name="Cervejeiro_Token", joinColumns=
    {@JoinColumn(name="cevejeiro_id")}, inverseJoinColumns=
      {@JoinColumn(name="token_id")})
	private List<Token> token;
	
	
	public Cervejeiro(int id, String nome, String senha, int idade, String email, String telefone, Cervejaria cervejaria) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.idade = idade;
		this.email = email;
		this.telefone = telefone;
		this.cervejaria = cervejaria;
	}
	public Cervejeiro() {
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Cervejaria getCervejaria() {
		return cervejaria;
	}
	
	public void setCervejaria(Cervejaria cervejaria) {
		this.cervejaria = cervejaria;
	}
	
	
	public List<Token> getToken() {
		return token;
	}
	public void setToken(List<Token> token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "Cervejeiro [id=" + id + ", nome=" + nome + ", senha=" + senha + ", idade=" + idade + ", email=" + email
				+ ", telefone=" + telefone + ", cervejaria=" + cervejaria + "]";
	}

	
	

}
