package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IUsuarioService;
import com.example.demo.interfaceService.InterfaceAsignaturaServices;
import com.example.demo.interfaceService.InterfaceCursoServices;
import com.example.demo.modelo.Asignatura;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.CursoAsignatura;
import com.example.demo.modelo.TipoUsuario;
import com.example.demo.modelo.User;

@Controller
@RequestMapping
public class ControladorCurso {

	@Autowired
	private InterfaceCursoServices service;
	@Autowired
	private InterfaceAsignaturaServices serviceAsignatura;
	@Autowired
	private IUsuarioService serviceUsuario;

	@GetMapping("/cursos")
	public String crudCurso(Model model) {
		List<Curso> cursos = service.listarCurso();
		model.addAttribute("cursos", cursos);
		model.addAttribute("curso", new Curso());
		return "curso/listarCursos";
	}

	@PostMapping("/guardarCurso")
	public String save(@Valid Curso c, Model model) {
		service.save(c);
		return "redirect:/cursos";
	}

	@GetMapping("/eliminarCurso/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/cursos";
	}

	@GetMapping("/cursos/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Curso> curso = service.listarId(id);
		model.addAttribute("curso", curso);
		return "curso/editarCurso";
	}

	@GetMapping("/cursos/agregarAsignaturas/{id}")
	public String agregarAsignaturas(@PathVariable int id, Model model) {
		List<Asignatura> asignaturas = serviceAsignatura.listarAsignatura();
		model.addAttribute("listaAsignaturas", asignaturas);
		Optional<Curso> curso = service.listarId(id);
		model.addAttribute("curso", curso);
		return "curso/agregarAsignaturas";
	}

	@PostMapping("/cursos/agregarAsignaturas/guardar")
	public String saveAsignaturas(@Valid Curso c, Model model) {
		System.out.print("DDDDDDDDDDDDDDDDDDDDDDDDD: "+ c.getCursoAsignaturas());
		for (CursoAsignatura ca : c.getCursoAsignaturas()) {
			if(ca.getCurso()!=null) {
				if(ca.getCurso().getId()==c.getId()) {
					System.out.print("ID u c: "+ ca.getCurso().getId());
					c.removeCursoAsignatura(ca);
				}
			}
		}
		//Manera de ingresar a una tabla de uno a muchos
		for (User u : c.getUsuarios()) {
			System.out.print(u);
			c.addUser(u);
		}
		
		//Antes estaba solo este save
		service.save(c);
		return "redirect:/cursos";
	}

	@GetMapping("/cursos/agregarEstudiantes/{id}")
	public String agregarEstudiantes(@PathVariable int id, Model model) {
		List<User> users = serviceUsuario.listarIdTipoUsuario(new TipoUsuario(3));
		model.addAttribute("listaEstudiantes", users);
		Optional<Curso> curso = service.listarId(id);
		model.addAttribute("curso", curso);
		return "curso/agregarEstudiantes";
	}

	@PostMapping("/cursos/agregarEstudiantes/guardar")
	public String saveEstudiantes(@Valid Curso c, Model model) {
		
		System.out.print("DDDDDDDDDDDDDDDDDDDDDDDDD: "+ c.getUsuarios());

		Optional<Curso> curso= service.listarId(c.getId());
		c.setCursoAsignaturas(curso.get().getCursoAsignaturas());
		
		System.out.print("ID C: "+c.getId());
		List<User> users = serviceUsuario.listarIdTipoUsuario(new TipoUsuario(3));
		for (User u : users) {
			if(u.getCurso()!=null) {
				if(u.getCurso().getId()==c.getId()) {
					System.out.print("ID u c: "+ u.getCurso().getId());
					c.removeUser(u);
				}
			}
		}
		//Manera de ingresar a una tabla de uno a muchos
		for (User u : c.getUsuarios()) {
			System.out.print(u);
			c.addUser(u);
		}

		service.save(c);

		return "redirect:/cursos";
	}

}
