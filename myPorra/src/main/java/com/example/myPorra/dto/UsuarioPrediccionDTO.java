package com.example.myPorra.dto;

import com.example.myPorra.model.EnumGanador;
import com.example.myPorra.model.EnumResultado;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPrediccionDTO {

    private Long id;

    @NotNull(message = "El usuario no puede ser nulo")
    private Long idUsuario;

    @NotNull(message = "El partido no puede ser nulo")
    private Long idPartido;

    @Min(value = 0, message = "Los goles del equipo 1 no pueden ser negativos")
    private Integer gfEquipo1;

    @Min(value = 0, message = "Los goles del equipo 2 no pueden ser negativos")
    private Integer gfEquipo2;

    @NotNull(message = "Debe haber un ganador o empate")
    private EnumGanador ganador;
    
    @NotNull(message = "Debe haber un ganador o empate")
    private EnumResultado resultado;
}
