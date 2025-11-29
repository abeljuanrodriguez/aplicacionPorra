package com.example.myPorra.basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.myPorra.model.Partido;
import com.example.myPorra.repository.PartidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartidoBasicService {

    private final PartidoRepository partidoRepository;

    public List<Partido> findAll()
    {
        return partidoRepository.findAll();
    }

    public Optional<Partido> findById(Long id)
    {
        return partidoRepository.findById(id);
    }

    public Partido guardar(Partido partido)
    {
        return partidoRepository.save(partido);
    }

    public void eliminar(Long id)
    {
        partidoRepository.deleteById(id);
    }

    public List<Partido> findByIdGrupo(Long idGrupo)
    {
        return partidoRepository.findByIdGrupo(idGrupo);
    }
}
