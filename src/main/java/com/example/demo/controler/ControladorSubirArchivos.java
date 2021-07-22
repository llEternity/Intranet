package com.example.demo.controler;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.interfaceService.InterfaceAsignaturaServices;
import com.example.demo.interfaceService.InterfaceCursoServices;
import com.example.demo.modelo.Archivo;
import com.example.demo.modelo.Asignatura;
import com.example.demo.modelo.Curso;
import com.example.demo.service.SubirArchivosService;

@Controller
public class ControladorSubirArchivos {
	@Autowired
	private SubirArchivosService subirarchivosservice;

	@Autowired
	private InterfaceCursoServices serviceCurso;

	@Autowired
	private InterfaceAsignaturaServices serviceAsignatura;

	@GetMapping("/SubirMaterial")
	public String index() {
		return "SubirMaterial";
	}

	@GetMapping("/SubirMaterialProfesor")
	public String SubirMaterialProfesor(Model model) {
		List<Curso> cursos = serviceCurso.listarCurso();
		model.addAttribute("cursos", cursos);
		model.addAttribute("curso", new Curso());
		return "SubirMaterialProfesor";
	}

	@PostMapping("/seleccionarAsignaturas")
	public String cursosPost(Model model, @ModelAttribute("curso") Curso cursos) {
		if (cursos.getId()==0) {
			return "redirect:/SubirMaterialProfesor";
		}
		System.out.print(cursos.getId());
		List<Asignatura> asignaturas = serviceAsignatura.listarAsignaturaPorCurso(cursos.getId());
		Optional<Curso> curso= serviceCurso.listarId(cursos.getId());
		System.out.print(asignaturas);
		model.addAttribute("curso", curso.get());
		model.addAttribute("asignaturas", asignaturas);
		model.addAttribute("archivo", new Archivo());
		return "seleccionarAsignaturas";
	}

	@PostMapping("upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, @ModelAttribute("archivo") Archivo archivo) {
		if (file.isEmpty()) {
			return "redirect:/SubirMaterialProfesor";
		}

		try {
			subirarchivosservice.saveFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/SubirMaterialProfesor";
	}
	
	@PostMapping("uploadE")
	public String uploadFileEstudiante(@RequestParam("file") MultipartFile file, @ModelAttribute("archivo") Archivo archivo) {
		if (file.isEmpty()) {
			return "redirect:/SubirMaterial";
		}

		try {
			subirarchivosservice.saveFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/SubirMaterial";
	}
}
