package com.example.myPorra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.basic.service.UsuarioBasicService;
import com.example.myPorra.dto.ResultadoDTO;
import com.example.myPorra.mapper.ResultadoMapper;

@Service
public class ResultadoService {

	@Autowired
	private UsuarioBasicService usuarioBasicService;

	@Autowired
	private ResultadoMapper resultadoMapper;

	public List<ResultadoDTO> findAll() {
		return this.resultadoMapper.mapListResultadoToResultadoDTO(this.usuarioBasicService.findAll());
	}

}
