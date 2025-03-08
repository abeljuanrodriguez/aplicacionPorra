package com.example.myPorra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.myPorra.model.UsuarioPrediccion;

public interface UsuarioPrediccionRepository extends JpaRepository<UsuarioPrediccion, Long> {

	@Query("SELECT up FROM UsuarioPrediccion up WHERE up.usuario.id = ?1")
	List<UsuarioPrediccion> findByIdUsuario(Long idUsuario);
	
	
}
