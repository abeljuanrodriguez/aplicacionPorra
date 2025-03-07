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

    @Mapping(target = "id", source = "usuario.id")
    @Mapping(target = "nombre", source = "usuario.nombre")
    @Mapping(target = "correo", source = "usuario.correo")
    @Mapping(target = "alias", source = "usuario.alias")
    @Mapping(target = "puntuacion", source = "usuario.puntuacion")
    UsuarioDTO mapUsuarioToUsuarioDTO(Usuario usuario);
    
    List<UsuarioDTO> mapListUsuarioToUsuarioDTO(List<Usuario> listaUsuarios);

    @Mapping(target = "id", source = "usuarioDTO.id")
    @Mapping(target = "nombre", source = "usuarioDTO.nombre")
    @Mapping(target = "correo", source = "usuarioDTO.correo")
    @Mapping(target = "alias", source = "usuarioDTO.alias")
    @Mapping(target = "puntuacion", source = "usuarioDTO.puntuacion")
    Usuario mapUsuarioDTOToUsuario(UsuarioDTO usuarioDTO);
    
    List<Usuario> mapListUsuarioDTOToUsuario(List<UsuarioDTO> listaUsuarioDTO);
}
