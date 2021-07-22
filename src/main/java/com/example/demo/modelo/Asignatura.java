package com.example.demo.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="asignatura")
public class Asignatura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAsignatura;
	
	@Column
	private String nombre;
	
	@OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
	private Set<Archivo> archivos;
	
	@OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
	private Set<Nota> notas;
	
	@OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
	private Set<CursoAsignatura> cursoAsignaturas;
	
	public Asignatura() {
		// TODO Auto-generated constructor stub
	}


	public Asignatura(int idAsignatura, String nombre) {
		super();
		this.idAsignatura = idAsignatura;
		this.nombre = nombre;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Set<Archivo> getArchivos() {
		return archivos;
	}


	public void setArchivos(Set<Archivo> archivos) {
		this.archivos = archivos;
	}


	public Set<Nota> getNotas() {
		return notas;
	}


	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}


	public Set<CursoAsignatura> getCursoAsignaturas() {
		return cursoAsignaturas;
	}


	public void setCursoAsignaturas(Set<CursoAsignatura> cursoAsignaturas) {
		this.cursoAsignaturas = cursoAsignaturas;
	}
	
	
	
	
}
