package com.desafio.gestaoGastosapi.model;

import java.time.LocalDateTime;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection="gestaoGastos")
public class GestaoGastos {


	@Id
	@Field
	private String id;
	@Field
	private Long codigoUsuario;
	
	public GestaoGastos() {
		
	}
	public GestaoGastos(Long codigoUsuario, String descricao, double valor, LocalDateTime data) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}
	@Field
	private String descricao;
	@Field
	private double valor;
	@Field
	private LocalDateTime data;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
}
