package com.example.myPorra.mapper;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.myPorra.dto.PartidoDTO;
import com.example.myPorra.model.Equipo;
import com.example.myPorra.model.Partido;
import com.example.myPorra.repository.EquipoRepository;

@Mapper(componentModel = "spring")
public interface PartidoMapper {
	
    PartidoMapper INSTANCE = Mappers.getMapper(PartidoMapper.class);

	@Mapping(target = "id", source = "usuarioDto.id")
    @Mapping(target = "equipo1", source = "usuarioDto.idEquipo1", qualifiedByName = "idToEquipo")
    @Mapping(target = "equipo2", source = "usuarioDto.idEquipo2", qualifiedByName = "idToEquipo")
    @Mapping(target = "fecha", source = "usuarioDto.fecha")
	@Mapping(target = "gfEquipo1", source = "usuarioDto.gfEquipo1")
	@Mapping(target = "gfEquipo2", source = "usuarioDto.gfEquipo2")
	Partido mapPartidoDTOToPartido(PartidoDTO usuarioDto, @Context EquipoRepository equipoRepository);
	
	List<Partido> mapListPartidoDTOToPartido(List<PartidoDTO> listaPartidosDto, @Context EquipoRepository equipoRepository);
	
	@Mapping(target = "id", source = "partido.id")
    @Mapping(target = "idEquipo1", source = "partido.equipo1.id")
    @Mapping(target = "idEquipo2", source = "partido.equipo2.id")
    @Mapping(target = "fecha", source = "partido.fecha")
	@Mapping(target = "gfEquipo1", source = "partido.gfEquipo1")
	@Mapping(target = "gfEquipo2", source = "partido.gfEquipo2")
	PartidoDTO mapPartidoToPartidoDTO(Partido partido);
	
	List<PartidoDTO> mapListPartidoToPartidoDTO(List<Partido> listaPartidosDto);

	@Named("idToEquipo")
	default Equipo idToEquipo(Long id, @Context EquipoRepository equipoRepository) {
	    if (id == null) return null;
	    return equipoRepository.findById(id).orElseThrow(() -> 
	        new IllegalArgumentException("Equipo no encontrado con ID: " + id));
	}
	
}
