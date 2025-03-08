package com.example.myPorra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myPorra.service.CalculoService;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/calcular")
@Getter
@Setter
public class CalculoController {

	@Autowired
	private CalculoService calculoService;

	@GetMapping
	public void calcular() {
		this.calculoService.calcular();
	}

}
