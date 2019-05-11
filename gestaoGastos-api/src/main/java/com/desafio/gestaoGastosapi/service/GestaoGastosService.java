package com.desafio.gestaoGastosapi.service;

import java.time.LocalDate;
import java.util.List;

import com.desafio.gestaoGastosapi.service.dto.GestaoGastosDTO;

public interface GestaoGastosService {

	public GestaoGastosDTO criar(GestaoGastosDTO gestaoGastosDTO);
	
	public List<GestaoGastosDTO>  buscarPorCodigoUsuario(Long codigoUsuario);
	
	public List<GestaoGastosDTO> buscarPorData(Long codigoUsuario,LocalDate data);
	
	public GestaoGastosDTO alterar(GestaoGastosDTO gestaoGastosDTO);
	
	
}
