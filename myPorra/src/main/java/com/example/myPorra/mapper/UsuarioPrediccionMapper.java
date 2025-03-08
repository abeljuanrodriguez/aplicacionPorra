package com.example.myPorra.mapper;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.myPorra.dto.UsuarioPrediccionDTO;
import com.example.myPorra.model.Partido;
import com.example.myPorra.model.Usuario;
import com.example.myPorra.model.UsuarioPrediccion;
import com.example.myPorra.repository.PartidoRepository;
import com.example.myPorra.repository.UsuarioRepository;

@Mapper(componentModel = "spring")
public interface UsuarioPrediccionMapper {

	UsuarioPrediccionMapper INSTANCE = Mappers.getMapper(UsuarioPrediccionMapper.class);

	@Mapping(target = "id", source = "usuarioPrediccion.id")
	@Mapping(target = "idUsuario", source = "usuarioPrediccion.usuario.id")
	@Mapping(target = "idPartido", source = "usuarioPrediccion.partido.id")
	@Mapping(target = "gfEquipo1", source = "usuarioPrediccion.gfEquipo1")
	@Mapping(target = "gfEquipo2", source = "usuarioPrediccion.gfEquipo2")
	UsuarioPrediccionDTO mapUsuarioPrediccionToUsuarioPrediccionDTO(UsuarioPrediccion usuarioPrediccion);

	List<UsuarioPrediccionDTO> mapListUsuarioPrediccionToUsuarioPrediccionDTO(
			List<UsuarioPrediccion> listaUsuariosPrediccion);

	@Mapping(target = "id", source = "usuarioPrediccionDTO.id")
	@Mapping(target = "usuario", source = "usuarioPrediccionDTO.idUsuario", qualifiedByName = "idToUsuario")
	@Mapping(target = "partido", source = "usuarioPrediccionDTO.idPartido", qualifiedByName = "idToPartido")
	@Mapping(target = "gfEquipo1", source = "usuarioPrediccionDTO.gfEquipo1")
	@Mapping(target = "gfEquipo2", source = "usuarioPrediccionDTO.gfEquipo2")
	UsuarioPrediccion mapUsuarioPrediccionDTOToUsuarioPrediccion(UsuarioPrediccionDTO usuarioPrediccionDTO,
			@Context UsuarioRepository usuarioRepository, @Context PartidoRepository partidoRepositorio);

	List<UsuarioPrediccion> mapListUsuarioPrediccionDTOToUsuarioPrediccion(
			List<UsuarioPrediccionDTO> listaUsuarioPrediccionDTO);

	@Named("idToUsuario")
	default Usuario idToUsuario(Long id, @Context UsuarioRepository usuarioRepository) {
		if (id == null)
			return null;
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado con ID: " + id));
	}

	@Named("idToPartido")
	default Partido idToPartido(Long id, @Context PartidoRepository partidoRepositorio) {
		if (id == null)
			return null;
		return partidoRepositorio.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado con ID: " + id));
	}
}
