package com.example.myPorra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.myPorra.model.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

	@Query("SELECT p FROM Partido p WHERE p.grupo.id = ?1")
	List<Partido> findByIdGrupo(Long idGrupo);
	
}
