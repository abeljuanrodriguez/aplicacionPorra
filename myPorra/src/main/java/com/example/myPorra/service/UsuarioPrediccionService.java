package com.example.myPorra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.basic.service.UsuarioPrediccionBasicService;
import com.example.myPorra.dto.UsuarioPrediccionDTO;
import com.example.myPorra.mapper.UsuarioPrediccionMapper;
import com.example.myPorra.model.EnumGanador;
import com.example.myPorra.model.UsuarioPrediccion;
import com.example.myPorra.repository.PartidoRepository;
import com.example.myPorra.repository.UsuarioRepository;

@Service
public class UsuarioPrediccionService {

	@Autowired
	private UsuarioPrediccionBasicService usuarioPrediccionBasicService;

	@Autowired
	private PartidoRepository partidoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioPrediccionMapper usuarioPrediccionMapper;

	public List<UsuarioPrediccionDTO> findAll() {
		return this.usuarioPrediccionMapper
				.mapListUsuarioPrediccionToUsuarioPrediccionDTO(this.usuarioPrediccionBasicService.findAll());
	}

	public UsuarioPrediccionDTO findById(Long id) {
		Optional<UsuarioPrediccion> usuarioOptional = this.usuarioPrediccionBasicService.findById(id);
		return usuarioOptional.map(this.usuarioPrediccionMapper::mapUsuarioPrediccionToUsuarioPrediccionDTO)
				.orElse(null);
	}

	public UsuarioPrediccionDTO guardar(UsuarioPrediccionDTO usuarioPrediccionDTO) {
		UsuarioPrediccion entity = this.usuarioPrediccionMapper
				.mapUsuarioPrediccionDTOToUsuarioPrediccion(usuarioPrediccionDTO, usuarioRepository, partidoRepository);
		return this.usuarioPrediccionMapper.mapUsuarioPrediccionToUsuarioPrediccionDTO(
				this.usuarioPrediccionBasicService.guardar(this.calcularGanadorEncuentro(entity)));
	}

	public UsuarioPrediccion calcularGanadorEncuentro(UsuarioPrediccion entity) {
		EnumGanador ganador = EnumGanador.calcularGanador(entity.getGfEquipo1(), entity.getGfEquipo2());
		entity.setGanador(ganador);
		return entity;
	}

	public void eliminar(Long id) {
		this.usuarioPrediccionBasicService.eliminar(id);
	}

	public List<UsuarioPrediccionDTO> findByIdUsuario(Long idUsuario) {
		return this.usuarioPrediccionMapper.mapListUsuarioPrediccionToUsuarioPrediccionDTO(
				this.usuarioPrediccionBasicService.findByIdUsuario(idUsuario));
	}
}
