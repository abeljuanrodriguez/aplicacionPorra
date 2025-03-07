package com.example.myPorra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipo_grupo")
@Getter
@Setter
public class EquipoGrupo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipo_grupo_seq")
	@SequenceGenerator(name = "equipo_grupo_seq", sequenceName = "equipo_grupo_seq", allocationSize = 1)
	private Long id;

	@ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;
	
	@ManyToOne
    @JoinColumn(name = "id_grupo", nullable = false)
    private Grupo grupo;
	
}
