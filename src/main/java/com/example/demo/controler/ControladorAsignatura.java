package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.INotaService;
import com.example.demo.interfaceService.InterfaceAsignaturaServices;
import com.example.demo.modelo.Asignatura;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Nota;
import com.example.demo.modelo.User;

@Controller
@RequestMapping
public class ControladorAsignatura {
	
	@Autowired
	private InterfaceAsignaturaServices service;
	
	@Autowired
	private INotaService notaService;
	
	//Seba
	@GetMapping("/listarAsignatura")
	public String listar(Model model) {
		List<Asignatura>listarAsignatura=service.listarAsignatura();
		model.addAttribute("asignatura", listarAsignatura);
		return "asignatura";
	}
	
	//Metodos de administrador
	
	@GetMapping("/asignaturas")
	public String listarAsignaturasAdmin(Model model) {
		List<Asignatura>listarAsignatura=service.listarAsignatura();
		model.addAttribute("asignaturas", listarAsignatura);
		model.addAttribute("asignatura", new Asignatura());
		return "asignatura/listarAsignaturasAdmin";
	}
	
	@PostMapping("/guardarAsignatura")
	public String save(@Valid Asignatura a, Model model) {
		service.save(a);
		return "redirect:/asignaturas";
	}
	
	@GetMapping("/asignaturas/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Asignatura> asignatura= service.listarId(id);
		model.addAttribute("asignatura",asignatura);
		return "asignatura/editar";
	}
	
	
	@GetMapping("/eliminarAsignatura/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/asignaturas";
	}
	
	//Aldair
	@GetMapping("/listarNotasEstudiante")
	public String listarNotas(Model model) {
		List<Nota>listadoNotas=notaService.listar();
		model.addAttribute("notas", listadoNotas);
		return "notasAlumno";
	}
	
}
