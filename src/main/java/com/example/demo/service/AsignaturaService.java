package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.InterfaceAsignaturaServices;
import com.example.demo.interfaces.IAsignatura;
import com.example.demo.modelo.Asignatura;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.User;

@Service
public class AsignaturaService implements InterfaceAsignaturaServices {

	@Autowired
	private IAsignatura data;
	
	@Override
	public List<Asignatura> listarAsignatura() {
		return (List<Asignatura>)data.findAll();
	}

	@Override
	public Optional<Asignatura> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Asignatura a) {
		int res=0;
		Asignatura asignatura= data.save(a);
		if (!asignatura.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

	@Override
	public List<Asignatura> listarAsignaturaPorCurso(int id) {
		return (List<Asignatura>)data.findByIdCurso(id);
	}

}
