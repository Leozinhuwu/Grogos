package br.edu.unifacear.classes;

import javax.persistence.*;

@Entity
public class Ingredientes implements IDBModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String alcool;
	private float teorAlcoolico;
	private float cevada;
	private String puroMalte;
	private String lupulo;
	private String fermento;
	private String especiarias;

	@OneToOne(mappedBy = "ingredientes")
	private Cerveja cerveja;

	public Ingredientes(int id, String alcool, float teorAlcoolico, float cevada, String puroMalte, String lupulo,
			String fermento, String especiarias, Cerveja cerveja) {

		this.id = id;
		this.alcool = alcool;
		this.teorAlcoolico = teorAlcoolico;
		this.cevada = cevada;
		this.puroMalte = puroMalte;
		this.lupulo = lupulo;
		this.fermento = fermento;
		this.especiarias = especiarias;
		this.cerveja = cerveja;
	}

	public Ingredientes() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlcool() {
		return alcool;
	}

	public void setAlcool(String alcool) {
		this.alcool = alcool;
	}

	public float getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(float teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public float getCevada() {
		return cevada;
	}

	public void setCevada(float cevada) {
		this.cevada = cevada;
	}

	public String getPuroMalte() {
		return puroMalte;
	}

	public void setPuroMalte(String puroMalte) {
		this.puroMalte = puroMalte;
	}

	public String getLupulo() {
		return lupulo;
	}

	public void setLupulo(String lupulo) {
		this.lupulo = lupulo;
	}

	public String getFermento() {
		return fermento;
	}

	public void setFermento(String fermento) {
		this.fermento = fermento;
	}

	public String getEspeciarias() {
		return especiarias;
	}

	public void setEspeciarias(String especiarias) {
		this.especiarias = especiarias;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}

	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return "uwu";
	}

	@Override
	public String toString() {
		return "Ingredientes [id=" + id + ", alcool=" + alcool + ", teorAlcoolico=" + teorAlcoolico + ", cevada="
				+ cevada + ", puroMalte=" + puroMalte + ", lupulo=" + lupulo + ", fermento=" + fermento
				+ ", especiarias=" + especiarias + ", cerveja=" + cerveja + "]";
	}

}
