package com.example.tpFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tpFinal.model.Estudiante;
import com.example.tpFinal.repository.IEstudianteRepository;


@Service 

public class EstudianteService implements IEstudianteService {
	
	@Autowired
	public IEstudianteRepository EstRepo;
	@Override
	public List<Estudiante> verEstudiante() {
		
		return EstRepo.findAll();
	}

	@Override
	public void CrearEstudiante(Estudiante p) {
		EstRepo.save(p);
		
	}

	@Override
	public void BorrarEstudiante(Long id) {
		EstRepo.deleteById(id);
		
	}

	@Override
	public Estudiante buscarEstudiante(Long id) {
		
		return EstRepo.findById(id).orElse(null);
	}

	



	@Override
	public void ModificarEstudiante(Long id, Estudiante p) { 
			Estudiante estudianteExistente = EstRepo.findById(id).orElse(null);

			    if (estudianteExistente != null) {
			    	estudianteExistente.setNombre(p.getNombre());
			    	estudianteExistente.setApellido(p.getApellido());
			    	estudianteExistente.setEmail(p.getEmail());;

			        EstRepo.save(estudianteExistente);
			    }
			
	}

}
