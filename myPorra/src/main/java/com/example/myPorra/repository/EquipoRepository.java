package com.example.myPorra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myPorra.model.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
	
}
