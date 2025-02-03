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

import com.example.myPorra.dto.UsuarioDTO;
import com.example.myPorra.service.UsuarioService;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/usuarios")
@Getter
@Setter
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<UsuarioDTO> findByAll() {
		return this.usuarioService.findAll();
	}

	@GetMapping("/{id}")
	public UsuarioDTO findById(@PathVariable Long id) {
		return this.usuarioService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDTO crear(@RequestBody UsuarioDTO usuario) {
		return this.usuarioService.guardar(usuario);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		this.usuarioService.eliminar(id);
	}
}
