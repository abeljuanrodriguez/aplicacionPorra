package com.example.myPorra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.basic.service.PartidoBasicService;
import com.example.myPorra.dto.PartidoDTO;
import com.example.myPorra.mapper.PartidoMapper;
import com.example.myPorra.model.EnumGanador;
import com.example.myPorra.model.Partido;
import com.example.myPorra.repository.EquipoRepository;

@Service
public class PartidoService {

	@Autowired
	private PartidoBasicService partidoBasicService;

	@Autowired
	private EquipoRepository equipoRepository;

	@Autowired
	private PartidoMapper partidoMapper;

	public List<PartidoDTO> findAll() {
		return this.partidoMapper.mapListPartidoToPartidoDTO(this.partidoBasicService.findAll());
	}

	public PartidoDTO findById(Long id) {
		Optional<Partido> partido = this.partidoBasicService.findById(id);
		return this.partidoMapper.mapPartidoToPartidoDTO(
				partido.orElseThrow(() -> new IllegalArgumentException("No se encontró el partido con ID: " + id)));
	}

	public PartidoDTO guardar(PartidoDTO partidoDto) {
		Partido entity = this.partidoMapper.mapPartidoDTOToPartido(partidoDto, equipoRepository);
		entity = this.partidoBasicService.guardar(this.calcularGanadorEncuentro(entity));
		return this.findById(entity.getId());
	}

	public Partido calcularGanadorEncuentro(Partido entity) {
		EnumGanador ganador = EnumGanador.calcularGanador(entity.getGfEquipo1(), entity.getGfEquipo2());
		entity.setGanador(ganador);
		return entity;
	}

	public void eliminar(Long id) {
		this.partidoBasicService.eliminar(id);
	}
}
