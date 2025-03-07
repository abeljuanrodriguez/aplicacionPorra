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
@Table(name = "grupo")
@Getter
@Setter
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_seq")
	@SequenceGenerator(name = "grupo_seq", sequenceName = "grupo_seq", allocationSize = 1)
	private Long id;

	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;
	
}
