package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.CursoAsignatura;
import com.example.demo.modelo.CursoAsignaturaId;

@Repository
public interface ICursoAsignatura extends CrudRepository<CursoAsignatura, CursoAsignaturaId>{

}
