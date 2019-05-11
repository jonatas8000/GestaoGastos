package com.desafio.gestaoGastosapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.gestaoGastosapi.model.GestaoGastos;

@Repository
public interface GestaoGastosRepository extends SolrCrudRepository<GestaoGastos, String> {
  
	@Query("codigoUsuario:?0 AND data:[?1T00:00:00Z TO ?1T23:59:59Z]")
	List<GestaoGastos>  findByCodigoUsuarioAndData(@Param ("id")Long codigoUsurario,@Param ("data")LocalDate data);
	
	 

}
