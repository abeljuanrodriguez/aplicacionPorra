package com.example.myPorra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.basic.service.EquipoBasicService;
import com.example.myPorra.dto.EquipoDTO;
import com.example.myPorra.mapper.EquipoMapper;
import com.example.myPorra.model.Equipo;

@Service
public class EquipoService {

	@Autowired
	private EquipoBasicService equipoBasicService;

	@Autowired
	private EquipoMapper equipoMapper;

	public List<EquipoDTO> findAll() {
		return this.equipoMapper.mapListEquipoToEquipoDTO(this.equipoBasicService.findAll());
	}

	public EquipoDTO findById(Long id) {
		Optional<Equipo> usuarioOptional = this.equipoBasicService.findById(id);
		return usuarioOptional.map(this.equipoMapper::mapEquipoToEquipoDTO).orElse(null);
	}

	public EquipoDTO guardar(EquipoDTO usuarioDto) {
		Equipo entity = this.equipoMapper.mapEquipoDTOToEquipo(usuarioDto);
		return this.equipoMapper.mapEquipoToEquipoDTO(this.equipoBasicService.guardar(entity));
	}

	public void eliminar(Long id) {
		this.equipoBasicService.eliminar(id);
	}
}
