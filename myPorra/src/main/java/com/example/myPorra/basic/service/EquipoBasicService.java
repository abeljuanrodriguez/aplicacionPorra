package com.example.myPorra.basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.myPorra.model.Equipo;
import com.example.myPorra.repository.EquipoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipoBasicService {

    private final EquipoRepository equipoRepository;

    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    public Equipo findById(Long id) {
        return equipoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Equipo con id " + id + " "
                + "no encontrado"));
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
