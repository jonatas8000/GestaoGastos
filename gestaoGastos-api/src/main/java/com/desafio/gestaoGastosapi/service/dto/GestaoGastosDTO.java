package com.desafio.gestaoGastosapi.service.dto;

import java.time.LocalDateTime;

public class GestaoGastosDTO {

	
	
	
	private Long codigoUsuario;
	
	private String descricao;
	
	private double valor;
	
	private LocalDateTime data;
	
	
	
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
