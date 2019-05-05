package com.desafio.gestaoGastosapi.service;

import com.desafio.gestaoGastosapi.service.dto.GestaoGastosDTO;

public interface GestaoGastosService {

	public GestaoGastosDTO criar(GestaoGastosDTO gestaoGastosDTO);
	
	public GestaoGastosDTO  buscarPorCodigoUsuario(Long id);
}
