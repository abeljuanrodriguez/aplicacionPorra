package com.example.myPorra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myPorra.dto.ResultadoDTO;
import com.example.myPorra.service.ResultadoService;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/resultado")
@Getter
@Setter
public class ResultadoController {

	@Autowired
	private ResultadoService resultadoService;

	@GetMapping
	public List<ResultadoDTO> findByAll() {
		return this.resultadoService.findAll();
	}

}
