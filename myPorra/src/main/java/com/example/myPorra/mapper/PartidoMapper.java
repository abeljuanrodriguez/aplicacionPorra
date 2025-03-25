package com.example.myPorra.mapper;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.myPorra.dto.PartidoDTO;
import com.example.myPorra.dto.PartidoDetalladoDTO;
import com.example.myPorra.dto.UsuarioPrediccionDTO;
import com.example.myPorra.model.Equipo;
import com.example.myPorra.model.Grupo;
import com.example.myPorra.model.Partido;
import com.example.myPorra.repository.EquipoRepository;
import com.example.myPorra.repository.GrupoRepository;

@Mapper(componentModel = "spring")
public interface PartidoMapper {
	
    PartidoMapper INSTANCE = Mappers.getMapper(PartidoMapper.class);

	@Mapping(target = "id", source = "partido.id")
    @Mapping(target = "equipo1", source = "partido.idEquipo1", qualifiedByName = "idToEquipo")
    @Mapping(target = "equipo2", source = "partido.idEquipo2", qualifiedByName = "idToEquipo")
	@Mapping(target = "grupo", source = "partido.idGrupo", qualifiedByName = "idToGrupo")
    @Mapping(target = "fecha", source = "partido.fecha")
	@Mapping(target = "gfEquipo1", source = "partido.gfEquipo1")
	@Mapping(target = "gfEquipo2", source = "partido.gfEquipo2")
	Partido mapPartidoDTOToPartido(PartidoDTO partido, @Context EquipoRepository equipoRepository, @Context GrupoRepository grupoRepository);
	
	List<Partido> mapListPartidoDTOToPartido(List<PartidoDTO> listaPartidosDto, @Context EquipoRepository equipoRepository, @Context GrupoRepository grupoRepository);
	
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
	
	@Named("idToGrupo")
	default Grupo idToGrupo(Long id, @Context GrupoRepository grupoRepository) {
	    if (id == null) return null;
	    return grupoRepository.findById(id).orElseThrow(() -> 
	        new IllegalArgumentException("Equipo no encontrado con ID: " + id));
	}

	@Mapping(target = "id", source = "partido.id")
    @Mapping(target = "idEquipo1", source = "partido.equipo1.id")
    @Mapping(target = "idEquipo2", source = "partido.equipo2.id")
	@Mapping(target = "idGrupo", source = "partido.grupo.id")
    @Mapping(target = "fecha", source = "partido.fecha")
	@Mapping(target = "gfEquipo1", source = "partido.gfEquipo1")
	@Mapping(target = "gfEquipo2", source = "partido.gfEquipo2")
	@Mapping(target = "nombreEquipo1", source = "partido.equipo1.nombre")
	@Mapping(target = "nombreEquipo2", source = "partido.equipo2.nombre")
	@Mapping(target = "flagEquipo1", source = "partido.equipo1.banderaUrl")
	@Mapping(target = "flagEquipo2", source = "partido.equipo2.banderaUrl")
	@Mapping(target = "isJugado", source = "partido.isJugado")
	@Mapping(target = "resultado", source = "partido.isJugado")
	PartidoDetalladoDTO mapListPartidoToPartidoDetalladoDTO(Partido partido);
	
	List<PartidoDetalladoDTO> mapListPartidoToPartidoDetalladoDTO(List<Partido> partido);

	@Mapping(target = "id", source = "partido.id")
    @Mapping(target = "idEquipo1", source = "partido.equipo1.id")
    @Mapping(target = "idEquipo2", source = "partido.equipo2.id")
	@Mapping(target = "idGrupo", source = "partido.grupo.id")
    @Mapping(target = "fecha", source = "partido.fecha")
	@Mapping(target = "gfEquipo1", source = "partido.gfEquipo1")
	@Mapping(target = "gfEquipo2", source = "partido.gfEquipo2")
	@Mapping(target = "nombreEquipo1", source = "partido.equipo1.nombre")
	@Mapping(target = "nombreEquipo2", source = "partido.equipo2.nombre")
	@Mapping(target = "flagEquipo1", source = "partido.equipo1.banderaUrl")
	@Mapping(target = "flagEquipo2", source = "partido.equipo2.banderaUrl")
	@Mapping(target = "isJugado", source = "partido.isJugado")
	@Mapping(target = "resultado", source = "prediccion.resultado")
	PartidoDetalladoDTO mapPartidoToPartidoDetalladoDTO(Partido partido, UsuarioPrediccionDTO prediccion);
	
}
