package br.edu.unifacear.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Token implements IDBModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String status;

	@ManyToMany(mappedBy = "token", cascade = CascadeType.ALL)
	private List<Cervejeiro> cervejeiros;

	public Token(int id, String nome, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.status = status;
		this.cervejeiros = new ArrayList<Cervejeiro>();
	}

	public Token() {
		super();
		this.cervejeiros = new ArrayList<Cervejeiro>();
	}

	public List<Cervejeiro> getCervejeiro() {
		return this.cervejeiros;
	}

	public void setCervejeiro(List<Cervejeiro> cervejeiros) {
		this.cervejeiros = cervejeiros;
	}

	public void addCervejeiro(Cervejeiro cervejeiro) {
		this.cervejeiros.add(cervejeiro);

	}

	public void removeCervejeiro(Cervejeiro cervejeiro) {
		this.cervejeiros.remove(cervejeiro);
	}

	public Cervejeiro getCervejeiro(int id) {
		return this.cervejeiros.get(id);
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
		return null;
	}

}
