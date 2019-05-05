package com.desafio.gestaoGastosapi.service.mapper;

import org.mapstruct.Mapper;

import com.desafio.gestaoGastosapi.model.GestaoGastos;
import com.desafio.gestaoGastosapi.service.dto.GestaoGastosDTO;

@Mapper(componentModel = "spring")
public interface GestaoGastosMapper extends EntityMapper<GestaoGastosDTO, GestaoGastos> {

}
