package com.example.myPorra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.myPorra.model.EquipoGrupo;

public interface EquipoGrupoRepository extends JpaRepository<EquipoGrupo, Long> {

	@Query("SELECT eg FROM EquipoGrupo eg WHERE eg.grupo.id = ?1")
	List<EquipoGrupo> findByIdGrupo(Long idGrupo);
	
}
