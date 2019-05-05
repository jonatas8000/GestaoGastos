package com.desafio.gestaoGastosapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.gestaoGastosapi.service.GestaoGastosService;
import com.desafio.gestaoGastosapi.service.dto.GestaoGastosDTO;

@RestController
@RequestMapping("/gestaoGastos")
public class GestaoGastosController {

	@Autowired
	private GestaoGastosService gestaoGastosService;
	
	
 /*	@PostConstruct
	public void addGestaoGastos() {
		List<GestaoGastos> gestaoGastos = new ArrayList<>();
		gestaoGastos.add(new GestaoGastos(4L, "Mercado", 100.93, LocalDateTime.now()));
		gestaoGastos.add(new GestaoGastos(5L, "Banco", 100.93, LocalDateTime.now()));
		
		gestaoGastosRepository.saveAll(gestaoGastos);  
		
//		gestaoRepository.deleteAll();
		

	} */
	

	@PostMapping
	public ResponseEntity<GestaoGastosDTO>criar(@Valid @RequestBody GestaoGastosDTO gestaoGastosDTO){
		GestaoGastosDTO gestaoGastosSalva = gestaoGastosService.criar(gestaoGastosDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(gestaoGastosSalva);
	}
	
	
	@GetMapping("/{codigo}")
    public List<GestaoGastosDTO> buscarPorCodigoUsuario(@PathVariable Long codigoUsuario) {
    	return gestaoGastosService.buscarPorCodigoUsuario(codigoUsuario);
    }
}
