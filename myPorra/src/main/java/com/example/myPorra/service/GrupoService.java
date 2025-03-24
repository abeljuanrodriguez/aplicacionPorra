package com.example.myPorra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.basic.service.GrupoBasicService;
import com.example.myPorra.dto.GrupoDTO;
import com.example.myPorra.mapper.GrupoMapper;
import com.example.myPorra.model.Grupo;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrupoService {

	private final GrupoBasicService grupoBasicService;

	private final GrupoMapper grupoMapper;
	
	public List<GrupoDTO> findAll() {
		return this.grupoMapper.mapListGrupoToGrupoDTO(this.grupoBasicService.findAll());
	}

	public GrupoDTO findById(Long id) {
		Optional<Grupo> grupoOptional = this.grupoBasicService.findById(id);
		return grupoOptional.map(this.grupoMapper::mapGrupoToGrupoDTO).orElse(null);
	}

	public GrupoDTO guardar(GrupoDTO grupoDto) {
		Grupo entity = this.grupoMapper.mapGrupoDTOToGrupo(grupoDto);
		return this.grupoMapper.mapGrupoToGrupoDTO(this.grupoBasicService.guardar(entity));
	}

	public void eliminar(Long id) {
		this.grupoBasicService.eliminar(id);
	}
}
