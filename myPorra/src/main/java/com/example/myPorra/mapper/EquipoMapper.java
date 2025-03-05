package com.example.myPorra.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.myPorra.dto.EquipoDTO;
import com.example.myPorra.model.Equipo;

@Mapper(componentModel = "spring")
public interface EquipoMapper {
	
    EquipoMapper INSTANCE = Mappers.getMapper(EquipoMapper.class);

	@Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "pais", source = "pais")
    @Mapping(target = "banderaUrl", source = "banderaUrl")
    EquipoDTO mapEquipoToEquipoDTO(Equipo usuario);
    
    List<EquipoDTO> mapListEquipoToEquipoDTO(List<Equipo> listaUsuarios);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "pais", source = "pais")
    @Mapping(target = "banderaUrl", source = "banderaUrl")
    Equipo mapEquipoDTOToEquipo(EquipoDTO usuarioDto);
    
    List<Equipo> mapListEquipoDTOToEquipo(List<EquipoDTO> listaUsuarioDTO);

	
}
