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

import com.example.myPorra.dto.GrupoDTO;
import com.example.myPorra.service.GrupoService;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/grupo")
@Getter
@Setter
public class GrupoController {

	@Autowired
	private GrupoService grupoService;

	@GetMapping
	public List<GrupoDTO> findByAll() {
		return this.grupoService.findAll();
	}

	@GetMapping("/{id}")
	public GrupoDTO findById(@PathVariable Long id) {
		return this.grupoService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GrupoDTO crear(@RequestBody GrupoDTO grupo) {
		return this.grupoService.guardar(grupo);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		this.grupoService.eliminar(id);
	}
}
