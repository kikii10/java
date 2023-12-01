package com.example.tpFinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "Estudiantes")
@Entity
@NoArgsConstructor 
@AllArgsConstructor
@Data
public class Estudiante {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    public Long id;
	    public String nombre;
	    public String apellido;
	    public String email;
	
}
