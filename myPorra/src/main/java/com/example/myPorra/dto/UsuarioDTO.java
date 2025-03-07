package com.example.myPorra.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String correo;
    private String alias;
    private Integer puntuacion;
}
