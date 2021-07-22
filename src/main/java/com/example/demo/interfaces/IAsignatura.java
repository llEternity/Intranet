package com.example.demo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Asignatura;

@Repository
public interface IAsignatura extends CrudRepository<Asignatura, Integer> {
	
	  @Query(value="select a.id_asignatura, a.nombre from asignatura a inner join curso_asignatura ca"
	  		+ " on a.id_asignatura=ca.id_asignatura inner join curso c"
	  		+ " on c.id=ca.id_curso where c.id = ?1", nativeQuery=true)
	  public List<Asignatura> findByIdCurso(int id);
}
