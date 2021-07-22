package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Asignatura;


public interface InterfaceAsignaturaServices {
	  public List<Asignatura>listarAsignatura();
	  public Optional<Asignatura>listarId(int id);	
	  public int save(Asignatura a);
	  public void delete(int id);
	  public List<Asignatura>listarAsignaturaPorCurso(int id);
	
}
