package com.example.myPorra.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartidoDetalladoDTO {

	private Long id;

	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
	private Long idEquipo1;

	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
	private Long idEquipo2;

	private Long idGrupo;

	private LocalDate fecha;

	private Integer gfEquipo1;

	private Integer gfEquipo2;

	private Boolean isJugado;

	public String nombreEquipo1;
	
	public String nombreEquipo2;
	
	public String flagEquipo1;
	
	public String flagEquipo2;

}
