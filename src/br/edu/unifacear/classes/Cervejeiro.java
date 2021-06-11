package br.edu.unifacear.classes;

import java.util.ArrayList;
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
	private String status;
	
	
	@ManyToOne
	@JoinColumn(name="cervejaria_id")
	private Cervejaria cervejaria;
	@ManyToMany
    @JoinTable(name="Cervejeiro_Token", joinColumns=
    {@JoinColumn(name="cevejeiro_id")}, inverseJoinColumns=
      {@JoinColumn(name="token_id")})
	private List<Token> token;
	
	
	public Cervejeiro(int id, String nome, String senha, int idade, String email, String status, String telefone, Cervejaria cervejaria) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.idade = idade;
		this.email = email;
		this.telefone = telefone;
		this.cervejaria = cervejaria;
		this.token = new ArrayList<Token>();
		this.status = "Ativo";
	}
	public Cervejeiro() {
		super();
		this.token = new ArrayList<Token>();
		this.status = "Ativo";
	}
	public List<Token> getToken() {
		return token;
	}
	public void setToken(List<Token> token) {
		this.token = token;
	}
	
	public void addToken(Token token) {
		this.token.add(token);
		
	}
	
	public void removeToken(Token token) {
		this.token.remove(token);
	}
	
	public Token getToken(int id) {
		return this.token.get(id);
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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return email;
	}

	
	

}
