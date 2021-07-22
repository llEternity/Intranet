package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.CursoAsignatura;

public interface ICursoAsignaturaService {
	public List<CursoAsignatura> listar();
	public Optional<CursoAsignatura>listarId(int id);
	public int save(CursoAsignatura ca);
	public void delete(int id);
}
