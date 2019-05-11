package com.desafio.gestaoGastosapi.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.gestaoGastosapi.service.GestaoGastosService;
import com.desafio.gestaoGastosapi.service.dto.GestaoGastosDTO;

@RestController
@RequestMapping("/api")
public class GestaoGastosController {

	@Autowired
	private GestaoGastosService gestaoGastosService;
	

	@PostMapping("/gestaoGastos")
	public ResponseEntity<GestaoGastosDTO>criarGestaoGastos(@Valid @RequestBody GestaoGastosDTO gestaoGastosDTO){
		GestaoGastosDTO gestaoGastosSalva = gestaoGastosService.criar(gestaoGastosDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(gestaoGastosSalva);
	}
	
	@PutMapping("/gestaoGastos")
	public ResponseEntity<GestaoGastosDTO>alterarGestaoGastos(@Valid @RequestBody GestaoGastosDTO gestaoGastosDTO){
		GestaoGastosDTO gestaoGastosSalva = gestaoGastosService.alterar(gestaoGastosDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(gestaoGastosSalva);
	}
	
	// gastos realizados a 5 segundos atrás.
	@GetMapping("/gestaoGastos/{codigoUsuario}")
    public List<GestaoGastosDTO> buscarPorCodigoUsuario(@PathVariable Long codigoUsuario) {
    	return gestaoGastosService.buscarPorCodigoUsuario(codigoUsuario);
    }
	
	@GetMapping("/gestaoGastos/{codigoUsuario}/{data}")
    public List<GestaoGastosDTO> buscarPorData(@PathVariable Long codigoUsuario,@PathVariable @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate data) {
    	return gestaoGastosService.buscarPorData(codigoUsuario,data);
    }
}
