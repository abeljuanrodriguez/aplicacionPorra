package com.example.myPorra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myPorra.model.Torneo;

public interface TorneoRepository extends JpaRepository<Torneo, Long> {
	
	
}
