package com.example.myPorra.basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.model.Equipo;
import com.example.myPorra.repository.EquipoRepository;

@Service
public class EquipoBasicService {

	@Autowired
    private EquipoRepository equipoRepository;
    
    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> findById(Long id) {
    	return equipoRepository.findById(id);
    }

    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void eliminar(Long id) {
    	equipoRepository.deleteById(id);
    }

	public Optional<Equipo> findByNombre(String nombre) {
		return equipoRepository.findByNombre(nombre.toUpperCase());
	}
}
