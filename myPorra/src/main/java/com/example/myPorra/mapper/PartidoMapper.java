package com.example.myPorra.mapper;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.myPorra.dto.EquipoDTO;
import com.example.myPorra.dto.PartidoDTO;
import com.example.myPorra.model.Equipo;
import com.example.myPorra.model.Partido;
import com.example.myPorra.repository.EquipoRepository;

@Mapper(componentModel = "spring")
public interface PartidoMapper {
	
    PartidoMapper INSTANCE = Mappers.getMapper(PartidoMapper.class);

	@Mapping(target = "usuarioDto.id", source = "id")
    @Mapping(target = "usuarioDto.equipo1", source = "equipo1", qualifiedByName = "idToEquipo")
    @Mapping(target = "usuarioDto.equipo2", source = "equipo2", qualifiedByName = "idToEquipo")
    @Mapping(target = "usuarioDto.fecha", source = "fecha")
	@Mapping(target = "usuarioDto.gfEquipo1", source = "gfEquipo1")
	@Mapping(target = "usuarioDto.gfEquipo2", source = "gfEquipo2")
	Partido mapPartidoDTOToPartido(PartidoDTO usuarioDto);
	
	@Named("idToEquipo")
	default Equipo idToEquipo(Long id, @Context EquipoRepository equipoRepository) {
	    if (id == null) return null;
	    return equipoRepository.findById(id).orElseThrow(() -> 
	        new IllegalArgumentException("Equipo no encontrado con ID: " + id));
	}
	
	List<Partido> mapListPartidoDTOToPartido(List<PartidoDTO> listaPartidosDto);
	
	@Mapping(target = "id", source = "partido.id")
    @Mapping(target = "idEquipo1", source = "partido.equipo1.id", qualifiedByName = "idToEquipo")
    @Mapping(target = "idEquipo2", source = "partido.equipo2.id", qualifiedByName = "idToEquipo")
    @Mapping(target = "fecha", source = "partido.fecha")
	@Mapping(target = "gfEquipo1", source = "partido.gfEquipo1")
	@Mapping(target = "gfEquipo2", source = "partido.gfEquipo2")
	PartidoDTO mapPartidoToPartidoDTO(Partido partido);
	
	List<PartidoDTO> mapListPartidoToPartidoDTO(List<Partido> listaPartidosDto);
	
	
}
