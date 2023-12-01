package com.example.tpFinal.RestController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tpFinal.model.Estudiante;
import com.example.tpFinal.service.EstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class Controlador {

    @Autowired
    private EstudianteService estSer;

    @GetMapping
    public String principal(Model model) {
        List<Estudiante> listaE = estSer.verEstudiante();
        model.addAttribute("estudiantes", listaE);
        return "listadoEstudiantes";
    }
	@GetMapping("/agregarEstudiante")
	public String agregarEstudiante(Model model) {
		model.addAttribute("nuevoEstudiante",new Estudiante());
		return "agregarEstudiante";
		
		
	}
	@PostMapping("/agregarEstudianteNuevo")
	public String agregarEstudianteNuevo(@ModelAttribute Estudiante nuevoEstudiante) {
		estSer.CrearEstudiante(nuevoEstudiante);
		return "redirect:/estudiantes";
		
		
	}
	@GetMapping("/modificarEstudiante/{id}")
	public String modificarEstudiante(@PathVariable long id, Model model){
		Estudiante r = estSer.buscarEstudiante(id);
		model.addAttribute("estudiante", r);
		return "modificarEstudiante";
	
}
	@PostMapping("/guardarEstudianteModificado")
	public String guardarEstudianteModificado(@ModelAttribute Estudiante estudianteNuevo) {
		estSer.CrearEstudiante(estudianteNuevo);
		return "redirect:/estudiantes";
		
		
		
	}
	@GetMapping("borrar/{id}")
	public String borrarEstudiante(@PathVariable long id) {
		
		estSer.BorrarEstudiante(id);
		return "redirect:/estudiantes";
	}
	
	
}