package com.example.myPorra.basic.service;

import java.util.List;
import java.util.Optional;

import com.example.myPorra.dto.GrupoDTO;
import org.springframework.stereotype.Service;

import com.example.myPorra.model.Grupo;
import com.example.myPorra.repository.GrupoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrupoBasicService {

	private final GrupoRepository grupoRepository;

	public List<Grupo> findAll() {
		return grupoRepository.findAll();
	}

	public Optional<Grupo> findById(Long id) {
		return grupoRepository.findById(id);
	}

	public Grupo guardar(Grupo grupo) {
		return grupoRepository.save(grupo);
	}

	public void eliminar(Long id) {
		grupoRepository.deleteById(id);
	}

    public List<Grupo> findByIdTorneo(Long idTorneo) {
       return grupoRepository.findByIdTorneo(idTorneo);
    }
}
