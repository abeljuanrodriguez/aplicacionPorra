package com.example.myPorra.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.myPorra.dto.TorneoDTO;
import com.example.myPorra.model.Torneo;

@Mapper(componentModel = "spring")
public interface TorneoMapper {

	TorneoMapper INSTANCE = Mappers.getMapper(TorneoMapper.class);

	@Mapping(target = "id", source = "id")
	@Mapping(target = "nombre", source = "nombre")
	TorneoDTO mapTorneoToTorneoDTO(Torneo guardar);

	List<TorneoDTO> mapListTorneoToTorneoDTO(List<Torneo> all);

	@Mapping(target = "id", source = "id")
	@Mapping(target = "nombre", source = "nombre")
	Torneo mapTorneoDTOToTorneo(TorneoDTO usuarioDto);

	List<Torneo> mapListTorneoDTOToTorneo(List<TorneoDTO> all);
	
}
