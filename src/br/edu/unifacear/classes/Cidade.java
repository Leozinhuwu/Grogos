package br.edu.unifacear.classes;

import javax.persistence.*;

@Entity
public class Cidade implements IDBModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;

	private String nome;

	public Cidade(int id, Estado estado, String nome) {
		super();
		this.id = id;
		this.estado = estado;
		this.nome = nome;
	}

	public Cidade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

}
