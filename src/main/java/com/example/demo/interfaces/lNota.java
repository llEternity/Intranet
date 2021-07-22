package com.example.demo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Asignatura;
import com.example.demo.modelo.Nota;
@Repository
public interface lNota extends CrudRepository<Nota, Integer>{
  
	
	
	@Query(value= "SELECT * FROM nota inner join asignatura on nota.id_asignatura =asignatura.id_asignatura WHERE "
			+ "nombre LIKE (%?1%) "
			,nativeQuery = true)
	
	public List<Nota> search(String keyword);
	
	
	public List<Nota> findByAsignaturaLike(Asignatura nombre_asignatura);
	

}


