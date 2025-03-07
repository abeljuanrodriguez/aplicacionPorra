package com.example.myPorra.basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.model.Grupo;
import com.example.myPorra.model.Usuario;
import com.example.myPorra.repository.GrupoRepository;
import com.example.myPorra.repository.UsuarioRepository;

@Service
public class GrupoBasicService {

	@Autowired
    private GrupoRepository grupoRepository;
    
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
}
