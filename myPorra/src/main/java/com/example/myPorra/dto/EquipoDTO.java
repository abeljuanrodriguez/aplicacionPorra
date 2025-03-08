package com.example.myPorra.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipoDTO {

	private Long id;

	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
	private String nombre;

	@NotBlank(message = "El país no puede estar vacío")
	@Size(max = 255, message = "El país no puede superar los 255 caracteres")
	private String pais;

	@Size(max = 255, message = "La URL de la bandera no puede superar los 255 caracteres")
	private String banderaUrl;
}
