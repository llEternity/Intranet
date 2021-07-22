package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.InterfaceCurso;
import com.example.demo.interfaces.InterfaceProfesor;
import com.example.demo.interfaceService.InterfaceCursoServices;
import com.example.demo.interfaceService.InterfaceProfesorServices;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Profesor;
import com.example.demo.modelo.User;
@Service
public class CursoService implements InterfaceCursoServices{
    @Autowired
	private InterfaceCurso data;
	
	@Override
	public List<Curso> listarCurso() {
	
		return (List<Curso>)data.findAll();
	}

	@Override
	public Optional<Curso> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Curso c) {
		int res=0;
		Curso curso= data.save(c);
		if (!curso.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
	
	
}
