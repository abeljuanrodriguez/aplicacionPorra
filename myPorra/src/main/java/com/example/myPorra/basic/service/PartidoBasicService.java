package com.example.myPorra.basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.model.Partido;
import com.example.myPorra.repository.PartidoRepository;

@Service
public class PartidoBasicService {

	@Autowired
    private PartidoRepository partidoRepository;
    
    public List<Partido> findAll() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> findById(Long id) {
    	return partidoRepository.findById(id);
    }

    public Partido guardar(Partido equipo) {
        return partidoRepository.save(equipo);
    }

    public void eliminar(Long id) {
    	partidoRepository.deleteById(id);
    }
}
