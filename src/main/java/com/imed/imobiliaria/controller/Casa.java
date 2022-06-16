package com.imed.imobiliaria.controller;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
class Casa {
	
	@ApiModelProperty(notes = "Imovel ID", example = "1", required = true)
	private @Id @GeneratedValue Long id;
	
	@ApiModelProperty(notes = "Tipo de negocio", example = "Aluguel", required = true)
	private String negocioImovel;
	
	@ApiModelProperty(notes = "Preco do Imovel(R$)", example = "25900.50", required = true)
	private Double precoImovel;
	
	@ApiModelProperty(notes = "Local Imovel", example = "Rua Alexandre da Motta, 15, Carazinho/RS", required = true)
	private String localImovel;
	
	@ApiModelProperty(notes = "Metragem do imovel(m2)", example = "35.2", required = true)
	private Double metragem;
	
	@ApiModelProperty(notes = "Banheiros quantidade", example = "2", required = false)
	private String banheiros;
	
	@ApiModelProperty(notes = "Comodos quantidade", example = "6", required = true)
	private String comodos;

	Casa() {}

	public Casa(String negocioImovel, 
			Double precoImovel, 
			String localImovel,  
			Double metragem, 
			String banheiros,
			String comodos) {
		super();
		this.negocioImovel = negocioImovel;
		this.precoImovel = precoImovel;
		this.localImovel = localImovel;
		this.metragem = metragem;
		this.banheiros = banheiros;
		this.comodos = comodos;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrecoImovel() {
		return precoImovel;
	}

	public void setPrecoImovel(Double precoImovel) {
		this.precoImovel = precoImovel;
	}

	public String getNegocioImovel() {
		return negocioImovel;
	}

	public void setNegocioImovel(String negocioImovel) {
		this.negocioImovel = negocioImovel;
	}

	public String getLocalImovel() {
		return localImovel;
	}

	public void setLocalImovel(String localImovel) {
		this.localImovel = localImovel;
	}

	public Double getMetragem() {
		return metragem;
	}

	public void setMetragem(Double metragem) {
		this.metragem = metragem;
	}

	public String getBanheiros() {
		return banheiros;
	}

	public void setBanheiros(String banheiros) {
		this.banheiros = banheiros;
	}

	public String getComodos() {
		return comodos;
	}

	public void setComodos(String comodos) {
		this.comodos = comodos;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Casa))
			return false;
		Casa casa = (Casa) o;
		return Objects.equals(this.id, casa.id) && Objects.equals(this.negocioImovel, casa.negocioImovel)
				&& Objects.equals(this.precoImovel, casa.precoImovel)
				&& Objects.equals(this.localImovel, casa.localImovel)
				&& Objects.equals(this.metragem, casa.metragem)
				&& Objects.equals(this.banheiros, casa.banheiros)
				&& Objects.equals(this.comodos, casa.comodos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.precoImovel, this.negocioImovel, this.localImovel);
	}

	@Override
	public String toString() {
		return "{"
				+ "id: " + id + "," 
				+ "negocioImovel: " + negocioImovel + ","  
				+ "precoImovel: " + precoImovel + "," 
				+ "localImovel: " + localImovel + "," 
				+ "metragem: " + metragem + "," 
				+ "banheiros: " + banheiros + "," 
				+ "comodos: " + comodos 
				+ "}";
	}



}

