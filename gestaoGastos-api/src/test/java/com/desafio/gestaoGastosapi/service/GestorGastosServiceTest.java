package com.desafio.gestaoGastosapi.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.gestaoGastosapi.model.GestaoGastos;
import com.desafio.gestaoGastosapi.repository.GestaoGastosRepository;
import com.desafio.gestaoGastosapi.service.dto.GestaoGastosDTO;
import com.desafio.gestaoGastosapi.service.impl.GestaoGastosServiceImpl;
import com.desafio.gestaoGastosapi.service.mapper.GestaoGastosMapper;

import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
public class GestorGastosServiceTest {

	@InjectMocks
	private GestaoGastosServiceImpl gestaoService;
	
	@Mock
	private GestaoGastosRepository gestaoGastosRepository;
	
	@Mock
	private GestaoGastosMapper gestaoGastosMapper;
	
	@Mock
	private GestaoGastos gestaoGastos;
	
	@Mock
	private Jedis jedis;
	
	
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
	}	
	
	private GestaoGastosDTO getGestaoGastosDTO() {
		GestaoGastosDTO gestaoGastosDTO = new GestaoGastosDTO();

		gestaoGastosDTO.setCodigoUsuario(45L);
		gestaoGastosDTO.setData(LocalDateTime.now());
		gestaoGastosDTO.setDescricao("gasto");
		gestaoGastosDTO.setValor(40.00);
		gestaoGastosDTO.setId("1");
		return gestaoGastosDTO;
	}

	private List<GestaoGastosDTO> getListGestaoGastosDTO() {
		List<GestaoGastosDTO> gestaoGastosDTO = new ArrayList<>();

		gestaoGastosDTO.add(getGestaoGastosDTO());
		return gestaoGastosDTO;
	}
	private GestaoGastos getGestaoGastos() {
		GestaoGastos gestaoGastos = new GestaoGastos();

		gestaoGastos.setCodigoUsuario(45L);
		gestaoGastos.setData(LocalDateTime.now());
		gestaoGastos.setDescricao("gasto");
		gestaoGastos.setValor(40.00);
		gestaoGastos.setId("1");
		return gestaoGastos;
	}
	
	private List<GestaoGastos> getListGestaoGastos() {
		List<GestaoGastos> gestaoGastos = new ArrayList<>();

		gestaoGastos.add(getGestaoGastos());
		return gestaoGastos;
	}
	
	private Set<String> carregarLista(){
		Set<String> lista = new HashSet<>();
		lista.add("teste");
		return lista;
	}
	
	@Test
	public void criar() {
		
		Mockito.when(this.gestaoGastosRepository.save(any(GestaoGastos.class))).thenReturn(getGestaoGastos());	
		Mockito.when(this.gestaoGastosMapper.toEntity(any(GestaoGastosDTO.class))).thenReturn(getGestaoGastos());
		Mockito.when(this.gestaoGastosMapper.toDto(any(GestaoGastos.class))).thenReturn(getGestaoGastosDTO());
		Mockito.when(this.jedis.hset(any(String.class), any(String.class), any(String.class))).thenReturn(1L);
		Mockito.when(this.jedis.expire(any(String.class), any(Integer.class))).thenReturn(1L);
		GestaoGastosDTO retorno = this.gestaoService.criar(getGestaoGastosDTO());
		assertNotNull(retorno);	
	}
	
	@Test
	public void alterar() {
		Mockito.when(this.gestaoGastosMapper.toDto(any(GestaoGastos.class))).thenReturn(getGestaoGastosDTO());
		Mockito.when(this.gestaoGastosRepository.save(any(GestaoGastos.class))).thenReturn(getGestaoGastos());
		Mockito.when(this.gestaoGastosMapper.toEntity(any(GestaoGastosDTO.class))).thenReturn(getGestaoGastos());
		GestaoGastosDTO retorno = this.gestaoService.alterar(getGestaoGastosDTO());
		assertNotNull(retorno);	
	}
	
	@Test
	public void buscarPorCodigoUsuario() {
		Mockito.when(this.jedis.keys(any(String.class))).thenReturn(carregarLista());
		Mockito.when(this.jedis.hget(any(String.class), contains("id"))).thenReturn("3");
		Mockito.when(this.jedis.hget(any(String.class), contains("descricao"))).thenReturn("financeiro");
		Mockito.when(this.jedis.hget(any(String.class), contains("valor"))).thenReturn("3.33");
		Mockito.when(this.jedis.hget(any(String.class), contains("data"))).thenReturn(LocalDateTime.now().toString());
		List<GestaoGastosDTO> retorno = this.gestaoService.buscarPorCodigoUsuario(1L);
		assertNotNull(retorno);
	}
	
	
	@Test
	public void buscarPorData() {
		Mockito.when(this.gestaoGastosMapper.toDto(getListGestaoGastos())).thenReturn(getListGestaoGastosDTO());
		Mockito.when(this.gestaoGastosRepository.findByCodigoUsuarioAndData(1L, LocalDate.now())).thenReturn(getListGestaoGastos());
		List<GestaoGastosDTO> retorno = this.gestaoService.buscarPorData(1L, LocalDate.now());
		assertNotNull(retorno);
	}
	
}
