package com.example.myPorra.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PartidoDTO {

	private Long id;

	private Long idEquipo1;

	private Long idEquipo2;
	
	private Long idGrupo;

	private LocalDate fecha;

	private Integer gfEquipo1;

	private Integer gfEquipo2;

	private Boolean isJugado;
	

}
