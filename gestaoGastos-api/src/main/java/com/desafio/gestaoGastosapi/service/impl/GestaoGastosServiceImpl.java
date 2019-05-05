package com.desafio.gestaoGastosapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.gestaoGastosapi.model.GestaoGastos;
import com.desafio.gestaoGastosapi.repository.GestaoGastosRepository;
import com.desafio.gestaoGastosapi.service.GestaoGastosService;
import com.desafio.gestaoGastosapi.service.dto.GestaoGastosDTO;
import com.desafio.gestaoGastosapi.service.mapper.GestaoGastosMapper;

@Service
@Transactional
public class GestaoGastosServiceImpl implements GestaoGastosService {

	@Autowired
	private GestaoGastosRepository gestaoGastosRepository;
	
	@Autowired
	private GestaoGastosMapper gestaoGastosMapper;
	
	@Override
	public GestaoGastosDTO criar(GestaoGastosDTO gestaoGastosDTO) {
		GestaoGastos gestaoGastos = gestaoGastosMapper.toEntity(gestaoGastosDTO);
		return gestaoGastosMapper.toDto(gestaoGastosRepository.save(gestaoGastos));
		
	}

	@Override
	public GestaoGastosDTO buscarPorCodigoUsuario(Long id) {
		return  gestaoGastosMapper.toDto(gestaoGastosRepository.findByCodigoUsuario(id));
	}

}
