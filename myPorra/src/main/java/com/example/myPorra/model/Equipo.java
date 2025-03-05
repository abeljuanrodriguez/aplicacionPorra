package com.example.myPorra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipos")
@Getter
@Setter
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipos_seq")
	@SequenceGenerator(name = "equipos_seq", sequenceName = "equipos_seq", allocationSize = 1)
	private Long id;

	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;

	@Column(name = "pais", nullable = false, length = 255)
	private String pais;

	@Column(name = "banderaUrl", length = 255)
	private String banderaUrl;

}