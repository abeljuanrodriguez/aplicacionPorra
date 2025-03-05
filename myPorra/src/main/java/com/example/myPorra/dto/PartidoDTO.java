package com.example.myPorra.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartidoDTO {

	private Long id;

	private Long idEquipo1;

	private Long idEquipo2;

	private LocalDate fecha;

	private Integer gfEquipo1;

	private Integer gfEquipo2;

}
