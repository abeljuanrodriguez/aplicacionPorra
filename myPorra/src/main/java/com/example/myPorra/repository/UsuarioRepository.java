package com.example.myPorra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.myPorra.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT us FROM Usuario us ORDER BY us.puntuacion DESC")
	List<Usuario> findResultados();
	
	
}
