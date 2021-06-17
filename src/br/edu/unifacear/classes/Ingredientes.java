package br.edu.unifacear.classes;

import javax.persistence.*;

@Entity
public class Ingredientes implements IDBModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private Boolean alcool;
	private float teorAlcoolico;
	private float cevada;
	private Boolean puroMalte;

	@ManyToOne
	@JoinColumn(name = "malte_id")
	private Malte malte;

	@ManyToOne
	@JoinColumn(name = "lupulo_id")
	private Lupulo lupulo;

	@ManyToOne
	@JoinColumn(name = "fermento_id")
	private Fermento fermento;

	private String especiarias;

	@OneToOne(mappedBy = "ingredientes")
	private Cerveja cerveja;

	public Ingredientes(int id, Boolean alcool, float teorAlcoolico, float cevada, Boolean puroMalte, Lupulo lupulo,
			Fermento fermento, String especiarias, Cerveja cerveja, Malte malte) {

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

	public Boolean getAlcool() {
		return alcool;
	}

	public void setAlcool(Boolean alcool) {
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

	public Boolean getPuroMalte() {
		return puroMalte;
	}

	public void setPuroMalte(Boolean puroMalte) {
		this.puroMalte = puroMalte;
	}

	public Lupulo getLupulo() {
		return lupulo;
	}

	public void setLupulo(Lupulo lupulo) {
		this.lupulo = lupulo;
	}

	public Fermento getFermento() {
		return fermento;
	}

	public void setFermento(Fermento fermento) {
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

	public Malte getMalte() {
		return malte;
	}

	public void setMalte(Malte malte) {
		this.malte = malte;
	}

	public String getEmail() {
		return "uwu";
	}

	@Override
	public String toString() {
		return "Ingredientes [id=" + id + ", nome=" + nome + ", alcool=" + alcool + ", teorAlcoolico=" + teorAlcoolico
				+ ", cevada=" + cevada + ", puroMalte=" + puroMalte + ", malte=" + malte + ", lupulo=" + lupulo
				+ ", fermento=" + fermento + ", especiarias=" + especiarias + ", cerveja=" + cerveja + "]";
	}

}
