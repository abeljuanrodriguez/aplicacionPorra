package com.example.myPorra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myPorra.model.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long> {
	
}
