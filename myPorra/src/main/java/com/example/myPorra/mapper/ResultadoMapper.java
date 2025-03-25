package com.example.myPorra.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.myPorra.dto.ResultadoDTO;
import com.example.myPorra.model.Usuario;

@Mapper(componentModel = "spring")
public interface ResultadoMapper {

	ResultadoMapper INSTANCE = Mappers.getMapper(ResultadoMapper.class);
	
	@Mapping(target = "nombre", source = "usuario.nombre")
    @Mapping(target = "alias", source = "usuario.alias")
	@Mapping(target = "puntuacion", source = "usuario.puntuacion")
	@Mapping(target = "idUsuario", source = "usuario.id")
	ResultadoDTO mapResultadoToResultadoDTO(Usuario usuario);
	
	List<ResultadoDTO> mapListResultadoToResultadoDTO(List<Usuario> all);

}
