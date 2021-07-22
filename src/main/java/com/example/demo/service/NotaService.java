package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.INotaService;
import com.example.demo.interfaces.InterfaceCurso;
import com.example.demo.interfaces.lNota;
import com.example.demo.modelo.Asignatura;
import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Nota;
import com.example.demo.modelo.User;
@Service
public class NotaService implements INotaService{

    @Autowired
	private lNota datas;
    
    @Autowired
	private lNota repo;
    
	@Override
	public List<Nota> listar() {
		return (List<Nota>)datas.findAll();
	}

	@Override
	public Optional<Nota> listarId(int id) {
		return datas.findById(id);
	}

	@Override
	public int save(Nota n) {
		int res=0;
		Nota nota= datas.save(n);
		if (!nota.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Nota> search (String keyword){
		return repo.search(keyword);
		
	}
	
	
	public List<Nota> findByAsignaturaLike(Asignatura nombre_asignatura){
		return datas.findByAsignaturaLike( nombre_asignatura);
		
		
	}


	
	
	
	
	

}
