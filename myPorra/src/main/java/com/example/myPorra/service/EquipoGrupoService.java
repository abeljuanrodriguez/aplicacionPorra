package com.example.myPorra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.basic.service.EquipoGrupoBasicService;
import com.example.myPorra.dto.EquipoGrupoDTO;
import com.example.myPorra.mapper.EquipoGrupoMapper;
import com.example.myPorra.model.EquipoGrupo;
import com.example.myPorra.repository.EquipoRepository;
import com.example.myPorra.repository.GrupoRepository;

@Service
public class EquipoGrupoService {

	@Autowired
	private EquipoGrupoBasicService equipoGrupoBasicService;
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private EquipoGrupoMapper equipoGrupoMapper;

	public List<EquipoGrupoDTO> findAll() {
		return this.equipoGrupoMapper.mapListEquipoGrupoToEquipoGrupoDTO(this.equipoGrupoBasicService.findAll());
	}

	public EquipoGrupoDTO findById(Long id) {
		Optional<EquipoGrupo> usuarioOptional = this.equipoGrupoBasicService.findById(id);
		return usuarioOptional.map(this.equipoGrupoMapper::mapEquipoGrupoToEquipoGrupoDTO).orElse(null);
	}

	public EquipoGrupoDTO guardar(EquipoGrupoDTO equipoGrupoDto) {
		EquipoGrupo entity = this.equipoGrupoMapper.mapEquipoGrupoDTOToEquipoGrupo(equipoGrupoDto,equipoRepository,grupoRepository);
		return this.equipoGrupoMapper.mapEquipoGrupoToEquipoGrupoDTO(this.equipoGrupoBasicService.guardar(entity));
	}

	public void eliminar(Long id) {
		this.equipoGrupoBasicService.eliminar(id);
	}

	public List<EquipoGrupoDTO> findByIdGrupo(Long idGrupo) {
		List<EquipoGrupo> lista = this.equipoGrupoBasicService.findByIdGrupo(idGrupo);
		return this.equipoGrupoMapper.mapListEquipoGrupoToEquipoGrupoDTO(lista);
	}
}
