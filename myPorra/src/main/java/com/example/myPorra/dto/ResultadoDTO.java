package com.example.myPorra.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoDTO {

    private String nombre;

    private String alias;

    private Integer puntuacion;
    
    private Long idUsuario;
}
