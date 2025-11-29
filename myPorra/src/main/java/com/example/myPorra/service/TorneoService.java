package com.example.myPorra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.basic.service.TorneoBasicService;
import com.example.myPorra.dto.TorneoDTO;
import com.example.myPorra.mapper.TorneoMapper;
import com.example.myPorra.model.Torneo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TorneoService {

	@Autowired
	private final TorneoBasicService torneoBasicService;

	@Autowired
	private TorneoMapper torneoMapper;

	public List<TorneoDTO> findAll() {
		return this.torneoMapper.mapListTorneoToTorneoDTO(this.torneoBasicService.findAll());
	}

	public TorneoDTO findById(Long id) {
		Optional<Torneo> usuarioOptional = this.torneoBasicService.findById(id);
		return usuarioOptional.map(this.torneoMapper::mapTorneoToTorneoDTO).orElse(null);
	}

	public TorneoDTO guardar(TorneoDTO usuarioDto) {
		Torneo entity = this.torneoMapper.mapTorneoDTOToTorneo(usuarioDto);
		return this.torneoMapper.mapTorneoToTorneoDTO(this.torneoBasicService.guardar(entity));
	}

	public void eliminar(Long id) {
		this.torneoBasicService.eliminar(id);
	}
}
