package com.example.myPorra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.myPorra.dto.PartidoDTO;
import com.example.myPorra.dto.PartidoDetalladoDTO;
import com.example.myPorra.service.PartidoService;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/partido")
@Getter
@Setter
public class PartidoController {

	@Autowired
	private PartidoService partidoService;

	@GetMapping
	public List<PartidoDTO> findByAll() {
		return this.partidoService.findAll();
	}

	@GetMapping("/{id}")
	public PartidoDTO findById(@PathVariable Long id) {
		return this.partidoService.findById(id);
	}
		
	@GetMapping("/findByIdGrupo/{idGrupo}/{idUsuario}")
	public List<PartidoDetalladoDTO> findByIdGrupo(@PathVariable Long idGrupo, @PathVariable Long idUsuario) {
		return this.partidoService.findByIdGrupo(idGrupo, idUsuario);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PartidoDTO crear(@Valid @RequestBody PartidoDTO partido) {
		return this.partidoService.guardar(partido);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		this.partidoService.eliminar(id);
	}
}
