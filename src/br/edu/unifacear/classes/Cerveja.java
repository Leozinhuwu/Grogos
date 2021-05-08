package br.edu.unifacear.classes;

import javax.persistence.*;

@Entity
public class Cerveja implements IDBModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String descricao;
	private String tipo;
	private String sabor;
	private String nomeCriador;
	private String paisOrigem;

	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name="ingredientes_id")
	private Ingredientes ingredientes;

	public Cerveja(int id, String name, String description, String type, String flavor, String creatorName,
			Usuario usuario, Ingredientes ingredientes) {
		super();
		this.setId(id);

		this.nome = name;
		this.descricao = description;
		this.tipo = type;
		this.sabor = flavor;

		this.nomeCriador = creatorName;
		this.usuario = usuario;
	}

	public Cerveja() {

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

	public void setNome(String name) {
		this.nome = name;
	}

	public String getDescription() {
		return descricao;
	}

	public void setDescription(String description) {
		this.descricao = description;
	}

	public String getType() {
		return tipo;
	}

	public void setType(String type) {
		this.tipo = type;
	}

	public String getFlavor() {
		return sabor;
	}

	public void setFlavor(String flavor) {
		this.sabor = flavor;
	}

	public String getCreatorName() {
		return nomeCriador;
	}

	public void setCreatorName(String creatorName) {
		this.nomeCriador = creatorName;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCountryOrigin() {
		return paisOrigem;
	}

	public void setCountryOrigin(String countryOrigin) {
		this.paisOrigem = countryOrigin;
	}

	public Ingredientes getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Ingredientes ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getEmail() {
		return "uwu";
	}

	@Override
	public String toString() {
		return "Cerveja id = " + id + ", name = " + nome + ", description = " + descricao + ", type = " + tipo
				+ ", flavor = " + sabor + "," + ", creatorName = " + nomeCriador + ", countryOrigin = " + paisOrigem
				+ ", usuario = " + usuario;
	}

}
