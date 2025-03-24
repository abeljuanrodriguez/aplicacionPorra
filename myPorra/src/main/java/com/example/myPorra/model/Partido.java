package com.example.myPorra.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "partido")
@Getter
@Setter
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partido_seq")
	@SequenceGenerator(name = "partido_seq", sequenceName = "partido_seq", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_grupo", nullable = false)
	private Grupo grupo;

	@ManyToOne
	@JoinColumn(name = "id_equipo1", nullable = false)
	private Equipo equipo1;

	@ManyToOne
	@JoinColumn(name = "id_equipo2", nullable = false)
	private Equipo equipo2;

	@Column(name = "fecha")
	private LocalDate fecha;

	@Column(name = "gfEquipo1")
	private Integer gfEquipo1;

	@Column(name = "gfEquipo2")
	private Integer gfEquipo2;

	@Column(name = "jugado")
	private Boolean isJugado;

	@Column(name = "ganador")
    @Enumerated(EnumType.STRING)
	private EnumGanador ganador;

}