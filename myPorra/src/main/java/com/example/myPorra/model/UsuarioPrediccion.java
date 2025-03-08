package com.example.myPorra.model;

import jakarta.persistence.Column;
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
@Table(name = "usuario_prediccion")
@Getter
@Setter
public class UsuarioPrediccion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_prediccion_seq")
	@SequenceGenerator(name = "usuario_prediccion_seq", sequenceName = "usuario_prediccion_seq", allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_partido", nullable = false)
	private Partido partido;

	@Column(name = "gfEquipo1")
	private Integer gfEquipo1;

	@Column(name = "gfEquipo2")
	private Integer gfEquipo2;

	@Column(name = "ganador")
	private EnumGanador ganador;

}
