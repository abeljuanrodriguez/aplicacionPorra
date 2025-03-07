package com.example.myPorra.mapper;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.myPorra.dto.EquipoGrupoDTO;
import com.example.myPorra.model.Equipo;
import com.example.myPorra.model.EquipoGrupo;
import com.example.myPorra.model.Grupo;
import com.example.myPorra.repository.EquipoRepository;
import com.example.myPorra.repository.GrupoRepository;

@Mapper(componentModel = "spring")
public interface EquipoGrupoMapper {
	
    EquipoGrupoMapper INSTANCE = Mappers.getMapper(EquipoGrupoMapper.class);

	@Mapping(target = "id", source = "equipoGrupo.id")
    @Mapping(target = "idEquipo", source = "equipoGrupo.equipo.id")
	@Mapping(target = "idGrupo", source = "equipoGrupo.grupo.id")
    EquipoGrupoDTO mapEquipoGrupoToEquipoGrupoDTO(EquipoGrupo equipoGrupo);
    
    List<EquipoGrupoDTO> mapListEquipoGrupoToEquipoGrupoDTO(List<EquipoGrupo> listaEquipos);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "equipo", source = "equipoGrupoDTO.idEquipo", qualifiedByName = "idToEquipo")
    @Mapping(target = "grupo", source = "equipoGrupoDTO.idGrupo", qualifiedByName = "idToGrupo")
    EquipoGrupo mapEquipoGrupoDTOToEquipoGrupo(EquipoGrupoDTO equipoGrupoDTO, @Context EquipoRepository equipoRepository, @Context GrupoRepository grupoRepository);
    
    List<EquipoGrupo> mapListEquipoGrupoDTOToEquipoGrupo(List<EquipoGrupoDTO> listaEquipoGrupoDTO);
    
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

}
