package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.interfaceService.ICursoAsignaturaService;
import com.example.demo.interfaces.ICursoAsignatura;
import com.example.demo.modelo.CursoAsignatura;

public class CursoAsignaturaService implements ICursoAsignaturaService{
	
	@Autowired
	private ICursoAsignatura data;

	@Override
	public List<CursoAsignatura> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CursoAsignatura> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(CursoAsignatura ca) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
