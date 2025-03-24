package com.example.myPorra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.myPorra.model.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {

	@Query("SELECT eq FROM Equipo eq WHERE UPPER(eq.nombre) = ?1")
	Optional<Equipo> findByNombre(String nombre);
	
}
