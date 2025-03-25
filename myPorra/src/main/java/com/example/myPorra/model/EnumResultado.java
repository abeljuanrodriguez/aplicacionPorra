package com.example.myPorra.model;

public enum EnumResultado {
	ACIERTO_TOTAL("acierto.total"), ACIERTO_PARCIAL("acierto.parcial"), FALLO("fallo");

	private final String descripcion;

	EnumResultado(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
