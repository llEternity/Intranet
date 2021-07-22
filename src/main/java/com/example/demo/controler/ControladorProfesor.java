package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.INotaService;
import com.example.demo.interfaceService.IUsuarioService;
import com.example.demo.interfaceService.InterfaceAsignaturaServices;
import com.example.demo.interfaceService.InterfaceCursoServices;
import com.example.demo.interfaceService.InterfaceProfesorServices;
import com.example.demo.interfaces.lNota;
import com.example.demo.modelo.Asignatura;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Nota;
import com.example.demo.modelo.Profesor;
import com.example.demo.modelo.User;
import com.example.demo.service.NotaService;

@Controller
@RequestMapping
public class ControladorProfesor {

	@Autowired
	private InterfaceProfesorServices service;
	@Autowired
	private InterfaceCursoServices service2;

	@Autowired
	private InterfaceAsignaturaServices service3;
	
	@Autowired
	private IUsuarioService serviceUser;
	
	@Autowired
	private INotaService servicenota;
	
	@Autowired
	private NotaService notaService;
	

	@GetMapping("/listarProfesor")
	public String listar(Model model) {
		List<Profesor> profesores = service.listarProfesor();
		model.addAttribute("profesores", profesores);
		return "verProfesores";
	}

	@GetMapping("/listarCursos")
	public String listarCurso(Model model) {
		List<Curso> cursos = service2.listarCurso();
		model.addAttribute("cursos", cursos);
		return "verCursos ";
	}

	@GetMapping("/listarAsignaturas")
	public String listarAsignatura(Model model) {
		List<Asignatura> asignaturas = service3.listarAsignatura();
		model.addAttribute("asignaturas", asignaturas);
		return "verAsignaturas";
	}

	/** redireccion a subir notas con el listado del curso **/
	@GetMapping({ "/SubirNotas" })
	public String listarCursoparaNotas(Model model) {
		List<Nota> notas = servicenota.listar();
		model.addAttribute("notas",notas);

		 /**
		List<Curso> cursos = service2.listarCurso();
		model.addAttribute("cursos", cursos);
		**/
		List<Asignatura> asignaturas = service3.listarAsignatura();
		model.addAttribute("asignaturas", asignaturas);
		/**
		List<User> users =  serviceUser.listar();
		model.addAttribute("users",users);		
		**/
		return "SubirNotas";
	}

	@GetMapping({ "/seleccionarAsignaturas" })
	public String seleccionarAsignaturas(Model model) {
		List<Curso> cursos = service2.listarCurso();
		model.addAttribute("cursos", cursos);
		List<Asignatura> asignaturas = service3.listarAsignatura();
		model.addAttribute("asignaturas", asignaturas);
		return "seleccionarAsignaturas";
	}

	
	@PostMapping("/guardarNota")
	public String save(@Valid Nota n, Model model) {
	    servicenota.save(n);
		return "redirect:/listarNotas";
	}
	
	
	@GetMapping("/editarNota/{id}")
	public String editar(@PathVariable int id, Model model) {
		List<Nota> notas = servicenota.listar();
		model.addAttribute("notas",notas);
		Optional<Nota> nota= servicenota.listarId(id);
		model.addAttribute("nota",nota);
		return "editarNota";
	}
	
	
	@GetMapping("/listarNotas")
	public String listarNotas(Model model)  {
		List<Nota>notas= servicenota.listar();  
		model.addAttribute("notas",notas);
		List<Asignatura> asignaturas = service3.listarAsignatura();
		model.addAttribute("asignaturas", asignaturas);
		return "listarNotas";
	}
	

	@GetMapping("/listarNotas2")
	public String listarNotas2(Model model)  {
		List<Nota>notas= servicenota.listar();
		model.addAttribute("notas",notas);
		return "listarNotas2";
	}
	
	@GetMapping("/listarNotas3")
	public String listarNotas3(Model model)  {
		List<Nota>notas= servicenota.listar();
		model.addAttribute("notas",notas);
		return "listarNotas3";
	}
	
	@GetMapping("/listarNotas4")
	public String listarNotas4(Model model)  {
		List<Nota>notas= servicenota.listar();
		model.addAttribute("notas",notas);
		return "listarNotas4";
	}
	
	@GetMapping("/listarNotas5")
	public String listarNotas5(Model model)  {
		List<Nota>notas= servicenota.listar();
		model.addAttribute("notas",notas);
		return "listarNotas5";
	}
	
	
	@GetMapping({ "/search" })
	public String search(@Param("keyword") String keyword , Model model) {
        List<Nota> searchResult = notaService.search(keyword);
        model.addAttribute("keyword" , keyword);
        model.addAttribute("Resultado de  " + keyword);
        model.addAttribute("searchResult" , searchResult);
        System.out.print(searchResult);
		return "search_result";
	}

	
	@GetMapping({ "/seleccionarCursoNota" })
	public String seleccionarCursoNota(Model model) {
		List<Nota>notas= servicenota.listar();
		model.addAttribute("notas",notas);
		
		
		
		return "seleccionarCursoNota";
	}
	
	
	
	 @PostMapping("seleccionarCursoNota")
	    public String notasPost(@ModelAttribute("notas") Nota notas) {
	        return "seleccionarCursoNota" ;      
	 }
	 
	 

	@GetMapping("/Administrador")
	public String Administrador() {
		return "Administrador";
	}

	@GetMapping("/Profesores")
	public String Profesores() {
		return "Profesores";
	}

	@GetMapping("/Estudiantes")
	public String Estudiantes() {
		return "Estudiantes";
	}

}
