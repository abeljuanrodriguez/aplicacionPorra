package com.example.myPorra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.basic.service.PartidoBasicService;
import com.example.myPorra.dto.PartidoDTO;
import com.example.myPorra.mapper.PartidoMapper;
import com.example.myPorra.model.Partido;

@Service
public class PartidoService {

	@Autowired
	private PartidoBasicService partidoBasicService;

	@Autowired
	private PartidoMapper partidoMapper;

	public List<PartidoDTO> findAll() {
		return this.partidoMapper.mapListPartidoToPartidoDTO(this.partidoBasicService.findAll());
	}

	public PartidoDTO findById(Long id) {
		Optional<Partido> usuarioOptional = this.partidoBasicService.findById(id);
		return usuarioOptional.map(this.partidoMapper::mapPartidoToPartidoDTO).orElse(null);
	}

	public PartidoDTO guardar(PartidoDTO usuarioDto) {
		Partido entity = this.partidoMapper.mapPartidoDTOToPartido(usuarioDto);
		return this.partidoMapper.mapPartidoToPartidoDTO(this.partidoBasicService.guardar(entity));
	}

	public void eliminar(Long id) {
		this.partidoBasicService.eliminar(id);
	}
}
