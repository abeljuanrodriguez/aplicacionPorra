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
public class PartidoDTO {

	private Long id;

	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
	private Long idEquipo1;

	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
	private Long idEquipo2;

	private LocalDate fecha;

	private Integer gfEquipo1;

	private Integer gfEquipo2;
	
	private Boolean isJugado;
	
}
