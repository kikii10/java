package com.example.tpFinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tpFinal.model.Estudiante;


@Service
public interface IEstudianteService {
	
	
		
		public List<Estudiante> verEstudiante();
		public void CrearEstudiante(Estudiante p);
		public void BorrarEstudiante(Long id);
		public Estudiante buscarEstudiante(Long id);
		void ModificarEstudiante(Long id, Estudiante p);

	


}
