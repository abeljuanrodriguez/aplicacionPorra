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

import com.example.myPorra.dto.EquipoDTO;
import com.example.myPorra.service.EquipoService;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/equipos")
@Getter
@Setter
public class EquipoController {

	@Autowired
	private EquipoService equipoService;

	@GetMapping
	public List<EquipoDTO> findByAll() {
		return this.equipoService.findAll();
	}

	@GetMapping("/{id}")
	public EquipoDTO findById(@PathVariable Long id) {
		return this.equipoService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EquipoDTO crear(@RequestBody EquipoDTO usuario) {
		return this.equipoService.guardar(usuario);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		this.equipoService.eliminar(id);
	}
}
