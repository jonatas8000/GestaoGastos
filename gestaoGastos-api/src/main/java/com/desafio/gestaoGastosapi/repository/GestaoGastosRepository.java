package com.desafio.gestaoGastosapi.repository;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.gestaoGastosapi.model.GestaoGastos;

@Repository
public interface GestaoGastosRepository extends SolrCrudRepository<GestaoGastos, String> {

	List<GestaoGastos> findByCodigoUsuario(Long id);

}
