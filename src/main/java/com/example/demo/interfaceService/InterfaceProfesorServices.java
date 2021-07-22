package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Profesor;


public interface InterfaceProfesorServices {
  public List<Profesor>listarProfesor();
  public Optional<Profesor>listarId(int id);	
  public int save(Profesor p);
  public void delete(int id);
	
}
