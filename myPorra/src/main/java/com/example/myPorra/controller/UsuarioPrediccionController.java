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

import com.example.myPorra.dto.UsuarioPrediccionDTO;
import com.example.myPorra.service.UsuarioPrediccionService;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/usuarioPrediccion")
@Getter
@Setter
public class UsuarioPrediccionController {

	@Autowired
	private UsuarioPrediccionService usuarioPrediccionService;

	@GetMapping
	public List<UsuarioPrediccionDTO> findByAll() {
		return this.usuarioPrediccionService.findAll();
	}

	@GetMapping("/{id}")
	public UsuarioPrediccionDTO findById(@PathVariable Long id) {
		return this.usuarioPrediccionService.findById(id);
	}
	
	@GetMapping("/findByIdUsuario/{idUsuario}")
	public List<UsuarioPrediccionDTO> findByIdUsuario(@PathVariable Long idUsuario) {
		return this.usuarioPrediccionService.findByIdUsuario(idUsuario);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioPrediccionDTO crear(@Valid @RequestBody UsuarioPrediccionDTO usuarioPrediccion) {
		return this.usuarioPrediccionService.guardar(usuarioPrediccion);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		this.usuarioPrediccionService.eliminar(id);
	}
	
}
