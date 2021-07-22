package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.InterfaceProfesor;
import com.example.demo.interfaceService.InterfaceProfesorServices;
import com.example.demo.modelo.Profesor;
@Service
public class ProfesorService implements InterfaceProfesorServices{
    @Autowired
	private InterfaceProfesor data;
	
	@Override
	public List<Profesor> listarProfesor() {
	
		return (List<Profesor>)data.findAll();
	}

	@Override
	public Optional<Profesor> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Profesor p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
