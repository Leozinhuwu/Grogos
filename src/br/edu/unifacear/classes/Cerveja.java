package br.edu.unifacear.classes;

import javax.persistence.*;

@Entity
public class Cerveja implements IDBModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="tipocerveja_id")
	private TipoCerveja tipo;
	
	@ManyToOne
	@JoinColumn(name="sabor_id")
	private Sabor sabor;
	
	@ManyToOne
	@JoinColumn(name="coloracao_id")
	private Coloracao coloracao;
	
	@ManyToOne
	@JoinColumn(name="pais_id")
	private Pais paisOrigem;

	@ManyToOne
	@JoinColumn(name="cervejeiro_id")
	private Cervejeiro cervejeiro;

	@OneToOne
	@JoinColumn(name="ingredientes_id")
	private Ingredientes ingredientes;

	public Cerveja(int id, String name, String description, TipoCerveja type, Sabor flavor,
			Cervejeiro cervejeiro, Coloracao coloracao, Ingredientes ingredientes) {
		super();
		this.setId(id);
		this.nome = name;
		this.descricao = description;
		this.tipo = type;
		this.sabor = flavor;
		this.coloracao = coloracao;


		this.cervejeiro = cervejeiro;
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

	public TipoCerveja getType() {
		return tipo;
	}

	public void setType(TipoCerveja type) {
		this.tipo = type;
	}

	public Sabor getFlavor() {
		return sabor;
	}

	public void setFlavor(Sabor flavor) {
		this.sabor = flavor;
	}


	public Cervejeiro getCervejeiro() {
		return cervejeiro;
	}

	public void setCervejeiro(Cervejeiro cervejeiro) {
		this.cervejeiro = cervejeiro;
	}

	public Pais getCountryOrigin() {
		return paisOrigem;
	}

	public void setCountryOrigin(Pais countryOrigin) {
		this.paisOrigem = countryOrigin;
	}

	public Coloracao getColoracao() {
		return coloracao;
	}

	public void setColoracao(Coloracao coloracao) {
		this.coloracao = coloracao;
	}

	public Ingredientes getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Ingredientes ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getEmail() {
		return null;
	}

	@Override
	public String toString() {
		return "Cerveja [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", tipo=" + tipo + ", sabor="
				+ sabor + ", coloracao=" + coloracao + ", paisOrigem=" + paisOrigem + ", cervejeiro=" + cervejeiro
				+ ", ingredientes=" + ingredientes + "]";
	}

	

}
