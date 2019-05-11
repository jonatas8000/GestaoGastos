package com.desafio.gestaoGastosapi.service.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class GestaoGastosDTO {

	
	
	private String id;
	
	@NotNull
	private Long codigoUsuario;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private double valor;
	
	@NotNull
	private LocalDateTime data;
	
	private String categoria;
	
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
