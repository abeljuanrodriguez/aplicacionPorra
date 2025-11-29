package com.example.myPorra.dto;

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
public class TorneoDTO {
	
	private Long id;
	
	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
	private String nombre;

}
