package com.example.myPorra.model;

public enum EnumGanador {
    LOCAL("Local"), VISITANTE("Visitante"), EMPATE("Empate");

    private final String descripcion;

    EnumGanador(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static EnumGanador calcularGanador(Integer gfEquipo1, Integer gfEquipo2) {
        if (gfEquipo1 > gfEquipo2) {
            return EnumGanador.LOCAL;
        } else if (gfEquipo2 > gfEquipo1) {
            return EnumGanador.VISITANTE;
        } else {
            return EnumGanador.EMPATE;
        }
    }
}
