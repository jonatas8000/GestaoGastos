package com.desafio.gestaoGastosapi.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.gestaoGastosapi.service.dto.GestaoGastosDTO;
import com.desafio.gestaoGastosapi.service.impl.GestaoGastosServiceImpl;

@RunWith(SpringRunner.class)
public class GestaoGastosControllerTest {

	@InjectMocks
	private GestaoGastosController gestaoGastosController;
	
	@Mock
	private GestaoGastosServiceImpl gestaoGastosService;
	
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
	
	
	@Test
	public void criarGastos() {		
		Mockito.when(this.gestaoGastosService.criar(any(GestaoGastosDTO.class))).thenReturn(getGestaoGastosDTO());	
		ResponseEntity<GestaoGastosDTO> retorno = this.gestaoGastosController.criarGestaoGastos(getGestaoGastosDTO());
		assertThat(retorno.getStatusCode(), is(HttpStatus.CREATED));
		assertNotNull(retorno);	
	}
	
	@Test
	public void alterarGastos() {		
		Mockito.when(this.gestaoGastosService.alterar(any(GestaoGastosDTO.class))).thenReturn(getGestaoGastosDTO());	
		ResponseEntity<GestaoGastosDTO> retorno = this.gestaoGastosController.criarGestaoGastos(getGestaoGastosDTO());
		assertThat(retorno.getStatusCode(), is(HttpStatus.CREATED));
		assertNotNull(retorno);	
	}
	
	@Test
	public void buscarPorCodigoUsuario() {
		Mockito.when(this.gestaoGastosService.buscarPorCodigoUsuario(1L)).thenReturn(getListGestaoGastosDTO());
		List<GestaoGastosDTO> retorno =this.gestaoGastosController.buscarPorCodigoUsuario(1L);
		assertNotNull(retorno);	
	}
	
	@Test
	public void buscarPorData() {
		Mockito.when(this.gestaoGastosService.buscarPorData(1L, LocalDate.now())).thenReturn(getListGestaoGastosDTO());
		List<GestaoGastosDTO> retorno =this.gestaoGastosController.buscarPorData(1L, LocalDate.now());
		assertNotNull(retorno);	
	}
	
}
