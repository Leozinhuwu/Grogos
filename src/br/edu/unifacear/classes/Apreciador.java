package br.edu.unifacear.classes;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Apreciador implements IDBModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String senha;
	private int idade;
	private String email;
	private String status;

	@ManyToMany
	@JoinTable(name = "Apreciador_TipoCerveja", joinColumns = {
			@JoinColumn(name = "apreciador_id") }, inverseJoinColumns = { @JoinColumn(name = "TipoCerveja_id") })
	private List<TipoCerveja> tipoCervejas;

	@ManyToMany
	@JoinTable(name = "Apreciador_Cerveja", joinColumns = {
			@JoinColumn(name = "apreciador_id") }, inverseJoinColumns = { @JoinColumn(name = "Cerveja_id") })
	private List<Cerveja> cervejasFavoritas;

	// constructors
	public Apreciador(int id, String nome, String senha, String status, int idade, String email) {
		super();
		this.setId(id);
		this.nome = nome;
		this.senha = senha;
		this.idade = idade;
		this.email = email;
		this.tipoCervejas = new ArrayList<TipoCerveja>();
		this.cervejasFavoritas = new ArrayList<Cerveja>();
		this.status = "Ativo";
	}

	public List<TipoCerveja> getTipoCervejas() {
		return tipoCervejas;
	}

	public void setTipoCervejas(List<TipoCerveja> tipoCervejas) {
		this.tipoCervejas = tipoCervejas;
	}

	// cervejas
	public List<Cerveja> getCervejasFavoritas() {
		return cervejasFavoritas;
	}

	public void setCervejasFavoritas(List<Cerveja> cervejasFavoritas) {
		this.cervejasFavoritas = cervejasFavoritas;
	}

	public Apreciador() {
		this.tipoCervejas = new ArrayList<TipoCerveja>();
		this.cervejasFavoritas = new ArrayList<Cerveja>();
		this.status = "Ativo";
	}

	// get and setters
	@Override
	public int getId() {

		return id;
	}

	// cervejas
	public void addCervejaFavoritas(Cerveja cervejasFavorita) {
		this.cervejasFavoritas.add(cervejasFavorita);

	}

	public void removeCervejaFavoritas(Cerveja cervejasFavorita) {
		this.cervejasFavoritas.remove(cervejasFavorita);
	}

	public Cerveja getCervejasFavorita(int id) {
		return this.cervejasFavoritas.get(id);
	}

	// tipos

	public void addTipoCerveja(TipoCerveja tipoCerveja) {
		this.tipoCervejas.add(tipoCerveja);

	}

	public void removeTipoCerveja(TipoCerveja tipoCerveja) {
		this.tipoCervejas.remove(tipoCerveja);
	}

	public TipoCerveja getTipoCerveja(int id) {
		return this.tipoCervejas.get(id);
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		Apreciador other = (Apreciador) obj;
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
		return email;
	}

}
