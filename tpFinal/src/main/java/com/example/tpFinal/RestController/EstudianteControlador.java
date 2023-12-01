package com.example.tpFinal.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tpFinal.model.Estudiante;
import com.example.tpFinal.service.IEstudianteService;

@RestController
public class EstudianteControlador {
	
	@Autowired
	private IEstudianteService EstSer;
	
	@PostMapping ("/new/Estudiante")
	public void agregarEstudiante (@RequestBody Estudiante e) {
		
		EstSer.CrearEstudiante(e);
		
		
	}
@GetMapping ("/mostrar/Estudiantes")
@ResponseBody
public List<Estudiante> verEstudiantes(){
	
	return EstSer.verEstudiante();
}

@GetMapping ("/getEstudianteById/{id}")
public Estudiante buscarEstudiante(@PathVariable Long id){
	
	return EstSer.buscarEstudiante(id);
}

@PutMapping("/update/Estudiante/{id}")
public void actualizarProfesor(@PathVariable Long id, @RequestBody Estudiante nuevoEstudiante) {
	
	EstSer.ModificarEstudiante(id, nuevoEstudiante);
    
}

/*si son mas de una seria @PathVariable("id") Long id, @PathVariable("nombre") string nombre*/
@DeleteMapping("/delete/Estudiante/{id}")
public void eliminarEstudiante(@PathVariable Long id) {
	EstSer.BorrarEstudiante(id);


	
}
}
/*@RestController
public class Controlador {
	
@Autowired
private IProfesorService ProSer;
	
	@PostMapping ("/new/profesor")
	public void agregarProfesor (@RequestBody Profesor p) {
		
		ProSer.CrearProfesor(p);
		
		
	}
	
@GetMapping ("/mostrar/profesores")
@ResponseBody
public List<Profesor> verProfesores(){
	
	return ProSer.verProfesor();
	



}
@GetMapping ("/getProfesorById/{id}")
public Profesor getProfesorPorId(@PathVariable Long id){
	
	return ProSer.buscarProfesor(id);
}

	@PutMapping("/update/profesor/{id}")
	public void actualizarProfesor(@PathVariable Long id, @RequestBody Profesor nuevoProfesor) {
		
		ProSer.ModificarProfesor(id, nuevoProfesor);
	    
	}
	@DeleteMapping("/delete/profesor/{id}")
	public void eliminarProfesor(@PathVariable Long id) {
		ProSer.BorrarProfesor(id);
	}*/