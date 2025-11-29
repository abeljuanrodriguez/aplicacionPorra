package com.example.myPorra.basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.model.Torneo;
import com.example.myPorra.repository.PartidoRepository;
import com.example.myPorra.repository.TorneoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TorneoBasicService {

    private final TorneoRepository torneoRepository;

    public List<Torneo> findAll() {
        return torneoRepository.findAll();
    }

    public Optional<Torneo> findById(Long id) {
        return torneoRepository.findById(id);
    }

    public Torneo guardar(Torneo usuario) {
        return torneoRepository.save(usuario);
    }

    public void eliminar(Long id) {
        torneoRepository.deleteById(id);
    }
}
