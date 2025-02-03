package com.example.myPorra.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.myPorra.dto.UsuarioDTO;
import com.example.myPorra.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "correo", source = "correo")
    @Mapping(target = "edad", source = "edad")
    @Mapping(target = "creadoEn", source = "creadoEn")
    UsuarioDTO mapUsuarioToUsuarioDTO(Usuario usuario);
    
    List<UsuarioDTO> mapListUsuarioToUsuarioDTO(List<Usuario> listaUsuarios);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "correo", source = "correo")
    @Mapping(target = "edad", source = "edad")
    @Mapping(target = "creadoEn", source = "creadoEn")
    Usuario mapUsuarioDTOToUsuario(UsuarioDTO usuarioDTO);
    
    List<Usuario> mapListUsuarioDTOToUsuario(List<Usuario> listaUsuarioDTO);
}
