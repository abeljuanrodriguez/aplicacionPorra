package com.example.myPorra.model;

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
import jakarta.validation.constraints.NotNull;
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

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_partido", nullable = false)
	private Partido partido;

	@NotNull
	@Column(name = "gfequipo1", nullable = false)
	private Integer gfEquipo1;

	@NotNull
	@Column(name = "gfequipo2", nullable = false)
	private Integer gfEquipo2;

	@Column(name = "ganador")
    @Enumerated(EnumType.STRING)
	private EnumGanador ganador;
	
	@Column(name = "resultado")
    @Enumerated(EnumType.STRING)
	private EnumResultado resultado;

}
