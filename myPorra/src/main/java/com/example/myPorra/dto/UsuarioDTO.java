package com.example.myPorra.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String correo;
    private Integer edad;
    private LocalDateTime creadoEn;
}
