package com.desafio.gestaoGastosapi.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.desafio.gestaoGastosapi.model.GestaoGastos;

public interface GestaoGastosRepository extends SolrCrudRepository<GestaoGastos, String> {

	GestaoGastos findByCodigoUsuario(Long id);

}
