package br.edu.unifacear.classes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class TipoCerveja implements IDBModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String nome;
	
	@ManyToMany(mappedBy="tipoCerveja", cascade = CascadeType.ALL)
	private Set<Apreciador> apreciador = new HashSet<Apreciador>();


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


	public Set<Apreciador> getApreciador() {
		return apreciador;
	}


	public void setApreciador(Set<Apreciador> apreciador) {
		this.apreciador = apreciador;
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
