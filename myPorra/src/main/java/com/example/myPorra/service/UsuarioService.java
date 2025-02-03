package com.example.myPorra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.basic.service.UsuarioBasicService;
import com.example.myPorra.dto.UsuarioDTO;
import com.example.myPorra.mapper.UsuarioMapper;
import com.example.myPorra.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioBasicService usuarioBasicService;

	@Autowired
	private UsuarioMapper usuarioMapper;

	public List<UsuarioDTO> findAll() {
		return this.usuarioMapper.mapListUsuarioToUsuarioDTO(this.usuarioBasicService.findAll());
	}

	public UsuarioDTO findById(Long id) {
		Optional<Usuario> usuarioOptional = this.usuarioBasicService.findById(id);
		return usuarioOptional.map(this.usuarioMapper::mapUsuarioToUsuarioDTO).orElse(null);
	}

	public UsuarioDTO guardar(UsuarioDTO usuarioDto) {
		Usuario entity = this.usuarioMapper.mapUsuarioDTOToUsuario(usuarioDto);
		return this.usuarioMapper.mapUsuarioToUsuarioDTO(this.usuarioBasicService.guardar(entity));
	}

	public void eliminar(Long id) {
		this.usuarioBasicService.eliminar(id);
	}
}
