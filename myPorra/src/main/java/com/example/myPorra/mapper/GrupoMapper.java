package com.example.myPorra.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.myPorra.dto.GrupoDTO;
import com.example.myPorra.model.Grupo;

@Mapper(componentModel = "spring")
public interface GrupoMapper {
	
    GrupoMapper INSTANCE = Mappers.getMapper(GrupoMapper.class);

    @Mapping(target = "id", source = "grupo.id")
    @Mapping(target = "nombre", source = "grupo.nombre")
    GrupoDTO mapGrupoToGrupoDTO(Grupo grupo);
    
    List<GrupoDTO> mapListGrupoToGrupoDTO(List<Grupo> listaGrupo);

    @Mapping(target = "id", source = "grupoDTO.id")
    @Mapping(target = "nombre", source = "grupoDTO.nombre")
    Grupo mapGrupoDTOToGrupo(GrupoDTO grupoDTO);
    
    List<Grupo> mapListGrupoDTOToGrupo(List<GrupoDTO> listaGrupoDTO);

}
