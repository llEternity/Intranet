package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.ITipoUsuarioServices;
import com.example.demo.interfaceService.IUsuarioService;
import com.example.demo.interfaceService.InterfaceAsignaturaServices;
import com.example.demo.modelo.Asignatura;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.TipoUsuario;
import com.example.demo.modelo.User;

@Controller
@RequestMapping
public class ControladorAdministrador {
	
	@Autowired
	private IUsuarioService service;
	
	@Autowired
	private InterfaceAsignaturaServices serviceAsignatura;
	
	@Autowired
	private ITipoUsuarioServices serviceTipo;
	
	@GetMapping("/listarUsuarios")
	public String listar(Model model) {
		List<User>users= service.listar();
		model.addAttribute("users",users);
		return "listarUsuarios";
	}
	
	@GetMapping("/registrarUsuario")
	public String agregar(Model model) {
		model.addAttribute("user", new User());
		return "registrarUsuario";
	}
	
	@PostMapping("/guardarUsuario")
	public String save(@Valid User u, Model model) {
		service.save(u);
		return "redirect:/listarUsuarios";
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<User> user= service.listarId(id);
		model.addAttribute("user",user.get());
		List<TipoUsuario> tipos= serviceTipo.listarTipos();
		model.addAttribute("tipos", tipos);
		return "editarUsuario";
	}
	
	
	@GetMapping("/eliminarUsuario/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listarUsuarios";
	}

}
