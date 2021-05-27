package br.edu.unifacear.classes;

import java.util.ArrayList;

import java.util.List;


import javax.persistence.*;

@Entity
public class TipoCerveja implements IDBModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String nome;
	
	@ManyToMany(mappedBy="tipoCervejas", cascade = CascadeType.ALL)
	private List<Apreciador> apreciadores;


	public TipoCerveja(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		this.apreciadores = new ArrayList<Apreciador>();
	}


	public TipoCerveja() {
		super();
		this.apreciadores = new ArrayList<Apreciador>();
	}
	
	public List<Apreciador> getApreciadores() {
		return this.apreciadores;
	}


	public void setApreciadores(List<Apreciador> apreciadores) {
		this.apreciadores = apreciadores;
	}
	
	public void addApreciador(Apreciador apreciador) {
		this.apreciadores.add(apreciador);
		
	}
	
	public void removeApreciador(Apreciador apreciador) {
		this.apreciadores.remove(apreciador);
	}
	
	public Apreciador getApreciador(int id) {
		return this.apreciadores.get(id);
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
		return  nome;
	}


	@Override
	public String getEmail() {
		return null;
	}
	
	
}
