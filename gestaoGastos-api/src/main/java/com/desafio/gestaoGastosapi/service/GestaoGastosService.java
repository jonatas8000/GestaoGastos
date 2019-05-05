package com.desafio.gestaoGastosapi.service;

import java.util.List;

import com.desafio.gestaoGastosapi.service.dto.GestaoGastosDTO;

public interface GestaoGastosService {

	public GestaoGastosDTO criar(GestaoGastosDTO gestaoGastosDTO);
	
	public List<GestaoGastosDTO>  buscarPorCodigoUsuario(Long id);
	
	
}
