package com.example.myPorra.repository;

import com.example.myPorra.dto.GrupoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myPorra.model.Grupo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    @Query("SELECT gr FROM Grupo gr WHERE gr.id = ?1")
    List<Grupo> findByIdTorneo(Long idTorneo);
}
