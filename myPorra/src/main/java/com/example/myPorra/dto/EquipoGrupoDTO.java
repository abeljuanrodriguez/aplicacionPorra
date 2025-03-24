package com.example.myPorra.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoGrupoDTO {

	private Long id;

	@NotBlank(message = "El equipo no puede estar vacío")
	private Long idEquipo;

	@NotBlank(message = "El grupo no puede estar vacío")
	private Long idGrupo;

	public EquipoGrupoDTO(Long idEquipo, Long idGrupo) {
		super();
		this.idEquipo = idEquipo;
		this.idGrupo = idGrupo;
	}

}
