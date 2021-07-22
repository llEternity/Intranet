package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Curso;


public interface InterfaceCursoServices {
	  public List<Curso>listarCurso();
	  public Optional<Curso>listarId(int id);	
	  public int save(Curso c);
	  public void delete(int id);
}	
