package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Curso;

@Repository

public interface InterfaceCurso extends CrudRepository<Curso, Integer> {

}
