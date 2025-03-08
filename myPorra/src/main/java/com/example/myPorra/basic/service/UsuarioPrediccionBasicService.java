package com.example.myPorra.basic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myPorra.model.UsuarioPrediccion;
import com.example.myPorra.repository.UsuarioPrediccionRepository;

@Service
public class UsuarioPrediccionBasicService {

	@Autowired
    private UsuarioPrediccionRepository usuarioPrediccionRepository;
    
    public List<UsuarioPrediccion> findAll() {
        return usuarioPrediccionRepository.findAll();
    }

    public Optional<UsuarioPrediccion> findById(Long id) {
    	return usuarioPrediccionRepository.findById(id);
    }

    public UsuarioPrediccion guardar(UsuarioPrediccion usuarioPrediccion) {
        return usuarioPrediccionRepository.save(usuarioPrediccion);
    }

    public void eliminar(Long id) {
    	usuarioPrediccionRepository.deleteById(id);
    }

	public List<UsuarioPrediccion> findByIdUsuario(Long idUsuario) {
		return usuarioPrediccionRepository.findByIdUsuario(idUsuario) ;
	}
}
