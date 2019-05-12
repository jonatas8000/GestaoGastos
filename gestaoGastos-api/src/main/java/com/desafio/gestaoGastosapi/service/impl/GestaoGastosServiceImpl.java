package com.desafio.gestaoGastosapi.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.gestaoGastosapi.model.GestaoGastos;
import com.desafio.gestaoGastosapi.repository.GestaoGastosRepository;
import com.desafio.gestaoGastosapi.service.GestaoGastosService;
import com.desafio.gestaoGastosapi.service.dto.GestaoGastosDTO;
import com.desafio.gestaoGastosapi.service.mapper.GestaoGastosMapper;

import redis.clients.jedis.Jedis;

@Service
@Transactional
public class GestaoGastosServiceImpl implements GestaoGastosService {

	@Autowired
	private GestaoGastosRepository gestaoGastosRepository;
	
	@Autowired
	private GestaoGastosMapper gestaoGastosMapper;
	
	private Jedis jedis;
	
	
	
	public GestaoGastosServiceImpl() {
		jedis = new Jedis("localhost");
	}
	

	@Override
	public GestaoGastosDTO criar(GestaoGastosDTO gestaoGastosDTO) {
		GestaoGastos gestaoGastos = gestaoGastosMapper.toEntity(gestaoGastosDTO);
		String id=UUID.randomUUID().toString();
		gestaoGastos.setId(id);
		gestaoGastos = gestaoGastosRepository.save(gestaoGastos);
		this.salvarRedis(gestaoGastos);
		return gestaoGastosMapper.toDto(gestaoGastos);
		
	}
	

	@Override
	public GestaoGastosDTO alterar(GestaoGastosDTO gestaoGastosDTO) {
		return gestaoGastosMapper.toDto(gestaoGastosRepository.save(gestaoGastosMapper.toEntity(gestaoGastosDTO)));
	}


	@Override
	public List<GestaoGastosDTO> buscarPorCodigoUsuario(Long codigoUsuario) {	
		return  this.carregarListGastos( jedis.keys(codigoUsuario+"*"),codigoUsuario);
	}
	
	@Override
	public List<GestaoGastosDTO> buscarPorData(Long codigoUsurario,LocalDate data) {
		return gestaoGastosMapper.toDto(gestaoGastosRepository.findByCodigoUsuarioAndData(codigoUsurario, data));

	}

	
	private void salvarRedis(GestaoGastos gestaoGastos) {
	
		jedis.hset(gestaoGastos.getCodigoUsuario()+gestaoGastos.getId(),"id", gestaoGastos.getId());
	    jedis.hset(gestaoGastos.getCodigoUsuario()+gestaoGastos.getId(), "descricao", gestaoGastos.getDescricao());
	    jedis.hset(gestaoGastos.getCodigoUsuario()+gestaoGastos.getId(), "valor", Double.toString(gestaoGastos.getValor()));
	    jedis.hset(gestaoGastos.getCodigoUsuario()+gestaoGastos.getId(), "data", gestaoGastos.getData().toString());
	    if(gestaoGastos.getCategoria()!=null)
	    jedis.hset(gestaoGastos.getCodigoUsuario()+gestaoGastos.getId(),"categoria", gestaoGastos.getCategoria());
	    
	    jedis.expire(gestaoGastos.getCodigoUsuario()+gestaoGastos.getId(), 5);     
	    
	  
	      
	}

	private List<GestaoGastosDTO> carregarListGastos(Set<String> chaves,Long codigoUsuario) {
		List<GestaoGastosDTO> listGestaoGastosDTO = new ArrayList<>();
		for(String chave : chaves) {
			GestaoGastosDTO gestaoGastosDTO = new GestaoGastosDTO();
			gestaoGastosDTO.setId(jedis.hget(chave, "id"));
			gestaoGastosDTO.setCodigoUsuario(codigoUsuario);
			gestaoGastosDTO.setDescricao(jedis.hget(chave, "descricao"));
			gestaoGastosDTO.setValor(Double.parseDouble(jedis.hget(chave, "valor")));
			gestaoGastosDTO.setData( LocalDateTime.parse(jedis.hget(chave, "data")));
			gestaoGastosDTO.setCategoria(jedis.hget(chave, "categoria"));
			
			listGestaoGastosDTO.add(gestaoGastosDTO);
		}
		return listGestaoGastosDTO;
	}


}
